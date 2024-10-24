package com.example.inventario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventario.interfaceService.InterfaceClienteServices;
import com.example.inventario.interfaces.ClienteInterface;
import com.example.inventario.models.Cliente;

@Service
public class ClienteService implements InterfaceClienteServices{
	
	
	@Autowired(required = true)
    private ClienteInterface datos;
	public ClienteService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Cliente>listar() {
		return (List<Cliente>)datos.findAll();
	}

	@Override
	public int guardar(Cliente c) {
		int resultado = 0;
		Cliente pro = datos.save(c);
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
	public Optional<Cliente>consultauncliente(int id) {
		// TODO Auto-generated method stub
		return datos.findById(id);
	}
	

}

