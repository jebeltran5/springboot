package com.example.inventario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventario.interfaceService.InterfaceFacturaServices;
import com.example.inventario.interfaces.FacturaInterface;
import com.example.inventario.models.Factura;

@Service
public class FacturaService implements InterfaceFacturaServices{
	
	@Autowired(required = true)
    private FacturaInterface datos;
	

	@Override
	public List<Factura>listar() {
		return (List<Factura>)datos.findAll();
	}

	@Override
	public int guardar(Factura f) {
		int resultado = 0;
		Factura pro = datos.save(f);
		if(!pro.equals(null)) {
			resultado = 1;
		}
		return resultado;
	}
	
	@Override
	public int consultarultima(){
	 int resultado = datos.consultaulrima();
	 return resultado;
	}

	@Override
	public void borrar(int id) {
		datos.deleteById(id);
		 
		
	}

	@Override
	public Optional<Factura>consultaunafactura(int id) {
		return datos.findById(id);
	}

	
	public FacturaService() {
		// TODO Auto-generated constructor stub
	}

}