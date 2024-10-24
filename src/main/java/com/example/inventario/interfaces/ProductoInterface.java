package com.example.inventario.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.inventario.models.Producto;
import com.example.inventario.models.Proveedor;

public interface ProductoInterface extends JpaRepository<Producto, Integer>{
	
	
       List<Producto> findByEstado(String estado);
       List<Producto> findByProveedor(Proveedor proveedor);
              
}
