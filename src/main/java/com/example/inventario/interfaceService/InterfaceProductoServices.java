package com.example.inventario.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.inventario.models.Producto;

public interface InterfaceProductoServices {
	
	public List<Producto>listar();
	public List<Producto>listarinactivos();
	public int guardar(Producto p);
	public void deshabilitar(int id);
	public Optional<Producto>consultaunproducto(int id);
	public Producto consultaproductodetalle(int id);
	List<Producto> findByProveedorId(int proveedorId);

}
