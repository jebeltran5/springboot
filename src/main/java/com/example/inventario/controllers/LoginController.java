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

import com.example.inventario.interfaceService.InterfaceUsuarioServices;
import com.example.inventario.models.Usuario;

@Controller
@RequestMapping
public class LoginController {
	     
	     @GetMapping("/login")
	     	public String mostrarLogin() {
	    	 return "login/login";
	     }

	public LoginController() {
		// TODO Auto-generated constructor stub
	}

}
