package com.example.inventario.interfaceService;

import java.util.List;
import java.util.Optional;


import com.example.inventario.models.FacturahasProducto;


public interface InterfaceFacturahasProductoServices {
	
	public List<FacturahasProducto>listar(int id);
	public List<FacturahasProducto>listarproduto(int id);
	public int guardar(FacturahasProducto facturahasproducto);
	public void borrar(int id);
	public Optional<FacturahasProducto>consultaundetalle(int id);
	

}
