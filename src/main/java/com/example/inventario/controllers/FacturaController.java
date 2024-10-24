package com.example.inventario.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.inventario.interfaceService.InterfaceClienteServices;
import com.example.inventario.interfaceService.InterfaceFacturaServices;
import com.example.inventario.interfaceService.InterfaceFacturahasProductoServices;
import com.example.inventario.interfaceService.InterfaceProductoServices;
import com.example.inventario.models.Cliente;
import com.example.inventario.models.Factura;
import com.example.inventario.models.FacturahasProducto;
import com.example.inventario.models.Producto;

@Controller
@RequestMapping
public class FacturaController {

	@Autowired
	private InterfaceFacturaServices service;
	@Autowired
	private InterfaceClienteServices servicecliente;
	@Autowired
	private InterfaceProductoServices serviceproducto;
	@Autowired
	private InterfaceFacturahasProductoServices servicedetalle;

	@GetMapping("Factura/listar")
	public String listar(Model model) {
		List<Factura> factura = service.listar();
		model.addAttribute("factura", factura);
		return "Factura/listar";

	}

	@GetMapping("Factura/insertar")
	public String facturainsertar(Model model) {
		List<Cliente> cliente = servicecliente.listar();
		List<Producto> producto = serviceproducto.listar();
		model.addAttribute("producto", producto);
		model.addAttribute("factura", new Factura());
		model.addAttribute("cliente", cliente);
		Date fecha = new Date();
		model.addAttribute("fecha", fecha);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String fechaFormateada = formato.format(fecha);
		model.addAttribute("fecha", fechaFormateada);
		return "Factura/insertar";

	}

	@PostMapping("Factura/guardar")
	public String guardar(@Validated @RequestParam("cantidad") List<Integer> cantidad,
			@RequestParam("producto") List<Integer> producto,
			@ModelAttribute("facturahasproducto") FacturahasProducto fp, @ModelAttribute("factura") Factura f,
			Model model) {
		service.guardar(f);
		for (int i = 0; i < cantidad.size(); i++) {
			FacturahasProducto facturahasproducto = new FacturahasProducto();
			facturahasproducto.setFactura(f);
			facturahasproducto.setCantidad(cantidad.get(i));
		   Producto productoresultado = serviceproducto.consultaproductodetalle(producto.get(i));
			Optional<Producto> productoOpt = serviceproducto.consultaunproducto(producto.get(i));
			facturahasproducto.setProducto(productoresultado);
			if(productoOpt.isPresent()) {
	        facturahasproducto.setProducto(fp.getProducto());
			servicedetalle.guardar(facturahasproducto);
			}
          	}
		return "redirect:/Factura/listar";
	}

	@GetMapping("Factura/borrar/{id}")
	public String borrar(@PathVariable int id, Model model) {
		service.borrar(id);
		return "redirect:/Factura/listar";
	}

	@GetMapping("Factura/actualizar/{id}")
	public String actualizar(@PathVariable int id, Model model) {
		Optional<Factura> factura = service.consultaunafactura(id);
		model.addAttribute("factura", factura);
		return "Factura/actualizar";

	}
	
	@GetMapping("Factura/imprimir/{id}")
	public String facturaimprimir(@PathVariable int id, Model model) {
		Optional<Factura> factura = service.consultaunafactura(id);
		List<FacturahasProducto>facturahasproducto=servicedetalle.listarproduto(id);
		model.addAttribute("factura", factura);
		model.addAttribute("productos", facturahasproducto);
		return "Factura/imprimir";

	}

	public FacturaController() {
		// TODO Auto-generated constructor stub
	}

}
