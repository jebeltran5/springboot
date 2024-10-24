package com.example.inventario.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.example.inventario.models.Cliente;


public interface ClienteInterface extends CrudRepository<Cliente, Integer> {

}
