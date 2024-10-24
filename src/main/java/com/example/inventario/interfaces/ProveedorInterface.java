package com.example.inventario.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventario.models.Proveedor;

@Repository
public interface ProveedorInterface extends JpaRepository<Proveedor, Integer>{
	
	

}
