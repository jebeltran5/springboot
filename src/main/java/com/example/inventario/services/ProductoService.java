package com.example.inventario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventario.interfaceService.InterfaceProductoServices;
import com.example.inventario.interfaces.ProductoInterface;
import com.example.inventario.models.Producto;

@Service
public class ProductoService implements InterfaceProductoServices{
	
    @Autowired(required =true)
    
    private ProductoInterface datos;
	public ProductoService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Producto> listar() {
		return (List<Producto>)datos.findByEstado("activo");
	}
	@Override
	public List<Producto> listarinactivos() {
		
		return (List<Producto>)datos.findByEstado("inactivo");
	}
	@Override
	public int guardar(Producto p) {
		int resultado = 0;
		Producto pro = datos.save(p);
		if(!pro.equals(null)) {
			resultado = 1;
		}
		return resultado;
	}

	@Override
	public void deshabilitar(int id) {
		
		
	}

	@Override
	public Optional<Producto> consultaunproducto(int id) {
		// TODO Auto-generated method stub
		return datos.findById(id);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Producto consultaproductodetalle(int id) {
		
		return datos.getById(id);
	}

	@Override
	public List<Producto> findByProveedorId(int proveedorId) {
		// TODO Auto-generated method stub
		return null;
	}

	
    
}

