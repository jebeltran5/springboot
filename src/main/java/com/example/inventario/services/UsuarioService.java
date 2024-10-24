package com.example.inventario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventario.interfaceService.InterfaceUsuarioServices;
import com.example.inventario.interfaces.UsuarioInterface;
import com.example.inventario.models.Usuario;

@Service
public class UsuarioService implements InterfaceUsuarioServices{
	
	
	@Autowired(required = true)
    private UsuarioInterface datos;

	@Override
	public List<Usuario>listar() {
		return (List<Usuario>)datos.findAll();
	}

	@Override
	public int guardar(Usuario u) {
		int resultado = 0;
		Usuario pro = datos.save(u);
		if(!pro.equals(null)) {
			resultado = 1;
		}
		return resultado;
	}

	@Override
	public void borrar(int id) {
		datos.deleteById(id);
		 
		
	}

	@Override
	public Optional<Usuario>consultaunusuario(int id) {
		// TODO Auto-generated method stub
		return datos.findById(id);
	}
	

	public UsuarioService() {
		// TODO Auto-generated constructor stub
	}

}
