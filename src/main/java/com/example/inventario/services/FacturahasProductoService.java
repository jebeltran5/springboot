package com.example.inventario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.inventario.interfaceService.InterfaceFacturahasProductoServices;
import com.example.inventario.interfaces.FacturahasProductoInterface;
import com.example.inventario.models.FacturahasProducto;

@Service
public class FacturahasProductoService implements InterfaceFacturahasProductoServices{
	
	@Autowired(required = true)
	private FacturahasProductoInterface datos;

	public FacturahasProductoService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<FacturahasProducto> listar(int id) {
		return (List<FacturahasProducto>)datos.findAll();
	}
	@Override
	public List<FacturahasProducto> listarproduto(int id) {
		return (List<FacturahasProducto>)datos.findByFacturaId(id);
	}
	@Override
	public int guardar(FacturahasProducto facturahasproducto) {
		int resultado = 0;
		FacturahasProducto pro = datos.save(facturahasproducto);
		if(!pro.equals(null)) {
			resultado = 1;
		}
		return resultado;
		
	}

	@Override
	public void borrar(int id) {
		// TODO Auto-generated method stub
		datos.deleteById(id);
	}

	@Override
	public Optional<FacturahasProducto> consultaundetalle(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}


	

}
