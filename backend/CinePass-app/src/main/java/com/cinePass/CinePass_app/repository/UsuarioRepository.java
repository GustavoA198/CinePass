package com.cinePass.CinePass_app.repository;

import com.cinePass.CinePass_app.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNombreContainingOrEmailContaining(String nombre, String email);

}
