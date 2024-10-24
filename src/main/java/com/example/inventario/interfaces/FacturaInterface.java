package com.example.inventario.interfaces;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.inventario.models.Factura;


public interface FacturaInterface extends JpaRepository<Factura, Integer>{
	
	@Query(value="SELECT MAX(id) FROM factura", nativeQuery=true)
	int consultaulrima();
	
}
