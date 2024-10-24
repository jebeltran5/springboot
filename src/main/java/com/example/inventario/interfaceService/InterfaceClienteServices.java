package com.example.inventario.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.inventario.models.Cliente;

public interface InterfaceClienteServices {
	public List<Cliente>listar();
	public int guardar(Cliente c);
	public void borrar(int id);
	public Optional<Cliente>consultauncliente(int id);

}
