package com.example.inventario.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventario.interfaceService.InterfaceProveedorServices;
import com.example.inventario.interfaces.ProductoInterface;
import com.example.inventario.interfaces.ProveedorInterface;
import com.example.inventario.models.Producto;
import com.example.inventario.models.Proveedor;

@Service
public class ProveedorService implements InterfaceProveedorServices{
	
	@Autowired
	private ProductoInterface productoDatos;
	
    @Autowired(required = true)
    private ProveedorInterface datos;
	public ProveedorService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Proveedor> listar() {
		return (List<Proveedor>)datos.findAll();
	}

	@Override
	public int guardar(Proveedor p) {
		int resultado = 0;
		Proveedor pro = datos.save(p);
		if(!pro.equals(null)) {
			resultado = 1;
		}
		return resultado;
	}

	@Override
	public void borrar(int id) {
		
		Optional<Proveedor> proveedorOptional = datos.findById(id);
        if (proveedorOptional.isPresent()) {
            Proveedor proveedor = proveedorOptional.get();
            List<Producto> productos = productoDatos.findByProveedor(proveedor);
            for(Producto producto :productos) {
            	productoDatos.delete(producto);
            }
        }
        datos.deleteById(id);
    }
		
	

	@Override
	public Optional<Proveedor> consultaunproveedor(int id) {
		// TODO Auto-generated method stub
		return datos.findById(id);
	}
	

}
