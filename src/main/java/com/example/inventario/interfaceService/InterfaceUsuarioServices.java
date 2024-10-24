package com.example.inventario.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.inventario.models.Usuario;

public interface InterfaceUsuarioServices {

	public List<Usuario>listar();
	public int guardar(Usuario u);
	public void borrar(int id);
	public Optional<Usuario>consultaunusuario(int id);
}
