package com.example.inventario.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.inventario.interfaceService.InterfaceProductoServices;
import com.example.inventario.interfaceService.InterfaceProveedorServices;
import com.example.inventario.models.Producto;
import com.example.inventario.models.Proveedor;


@Controller
@RequestMapping
public class ProductoController {

	@Autowired
	private InterfaceProductoServices service;
	
	@Autowired
	private InterfaceProveedorServices serviceproveedor; 
	
	 @GetMapping("Producto/listar")
	    public String listar(Model model) {
	    	List<Producto>producto=service.listar();
	    	List<Proveedor>proveedor=serviceproveedor.listar();
	    	model.addAttribute("proveedor",proveedor);
	    	model.addAttribute("producto",producto);
	    	return "Producto/listar";
	    	
	    }
	   @GetMapping("Producto/inactivo")
	    public String listarinactivo(Model model) {
	    	List<Producto>producto=service.listarinactivos();
	    	model.addAttribute("producto",producto);
	    	return "Producto/listarinactivo";
	    	
	    }
	   
	 @GetMapping("Producto/insertar")
	    public String productoinsertar(Model model) {
		 List<Proveedor>proveedor=serviceproveedor.listar();
	    	model.addAttribute("producto", new Producto());
	    	model.addAttribute("proveedor", proveedor);
	    	return "Producto/insertar";
	    	
	    }
	 @PostMapping("Producto/guardar")
	    public String guardar(@Validated Producto p,Model model) {
	    	service.guardar(p);
	    	return "redirect:/Producto/listar";
	    }
	 @GetMapping("Producto/deshabilitar/{id}")
 	public String deshabilitar(@PathVariable int id, Model model) {
 		Optional<Producto>producto=service.consultaunproducto(id);
 		List<Proveedor>proveedor=serviceproveedor.listar();
 		model.addAttribute("proveedor", proveedor);
 		model.addAttribute("producto", producto);
 		return "/Producto/deshabilitar";
 	}   
	 
	 @GetMapping("Producto/actualizar/{id}")
     public String actualizar(@PathVariable int id,Model model) {
    	 Optional<Producto>producto=service.consultaunproducto(id);
    	 List<Proveedor>proveedor=serviceproveedor.listar();
    	 model.addAttribute("proveedor", proveedor);
    	 model.addAttribute("producto", producto);
    	 return "Producto/actualizar";
    	 
     }
	public ProductoController() {
		
	}

}

