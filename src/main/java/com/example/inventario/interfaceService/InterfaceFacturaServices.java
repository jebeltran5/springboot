package com.example.inventario.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.inventario.models.Factura;

public interface InterfaceFacturaServices {
	
	public List<Factura>listar();
	public int guardar(Factura f);
	public void borrar(int id);
	public Optional<Factura>consultaunafactura(int id);
	public int consultarultima();

}
