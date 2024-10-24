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

import com.example.inventario.interfaceService.InterfaceProveedorServices;
import com.example.inventario.models.Proveedor;

@Controller
@RequestMapping
public class ProveedorController {
	
	@Autowired
	private InterfaceProveedorServices service;
	
	
	
    @GetMapping("Proveedor/listar")
    public String listar(Model model) {
    	List<Proveedor>proveedor=service.listar();
    	model.addAttribute("proveedor",proveedor);
    	return "Proveedor/listar";
    	
    }
    @GetMapping("Proveedor/insertar")
    public String proveedorinsertar(Model model) {
    	model.addAttribute("proveedor", new Proveedor());
    	return "Proveedor/insertar";
    	
    }
    
    @PostMapping("Proveedor/guardar")
    public String guardar(@Validated Proveedor p,Model model) {
    	service.guardar(p);
    	return "redirect:/Proveedor/listar";
    }
    
    @GetMapping("Proveedor/borrar/{id}")
    	public String borrar(@PathVariable int id, Model model) {
    		service.borrar(id);
    		return "redirect:/Proveedor/listar";
    	}
    
     @GetMapping("Proveedor/actualizar/{id}")
     public String actualizar(@PathVariable int id,Model model) {
    	 Optional<Proveedor>proveedor=service.consultaunproveedor(id);
    	 model.addAttribute("proveedor", proveedor);
    	 return "Proveedor/actualizar";
    	 
     }
	public ProveedorController() {
		// TODO Auto-generated constructor stub
	}

}
