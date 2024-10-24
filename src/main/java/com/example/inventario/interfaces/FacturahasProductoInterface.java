package com.example.inventario.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.inventario.models.FacturahasProducto;

public interface FacturahasProductoInterface extends JpaRepository<FacturahasProducto, Integer>{
	

	
	List<FacturahasProducto> findByFacturaId(int facturaId);
	//@Query(value="SELECT f.factura_id,f.producto_id,f.cantidad,p.nombre,pvalor,p.id FROM facturahasproducto f INNER JOIN producto p ON f.producto_id = p.id WHERE f.factura_id = :idfactura",nativeQuery=true)
    // List<FacturahasProducto> consultarproductosdetalle(@Param("idfactura")int idfactura);
}
