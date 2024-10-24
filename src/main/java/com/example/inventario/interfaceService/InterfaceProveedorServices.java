package com.example.inventario.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.inventario.models.Proveedor;

public interface InterfaceProveedorServices {
    
	public List<Proveedor>listar();
	public int guardar(Proveedor p);
	public void borrar(int id);
	public Optional<Proveedor>consultaunproveedor(int id);	
}
