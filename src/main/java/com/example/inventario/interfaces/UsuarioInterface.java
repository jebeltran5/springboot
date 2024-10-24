package com.example.inventario.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventario.models.Usuario;

public interface UsuarioInterface extends JpaRepository<Usuario, Integer>{

}
