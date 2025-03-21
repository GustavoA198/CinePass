package com.cinePass.CinePass_app.repository;

import com.cinePass.CinePass_app.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
