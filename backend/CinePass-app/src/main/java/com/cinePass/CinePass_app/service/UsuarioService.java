package com.cinePass.CinePass_app.service;

import com.cinePass.CinePass_app.dto.UsuarioDTO;
import com.cinePass.CinePass_app.entity.Usuario;
import com.cinePass.CinePass_app.error.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Usuario crearUsuario(Usuario usuario);
    Optional<Usuario> obtenerUsuarioPorId(Long id) throws NotFoundException;
    List<Usuario> obtenerTodosLosUsuarios();
    Usuario actualizarUsuario(Long id, UsuarioDTO usuarioActualizado) throws NotFoundException;
    void desactivarUsuario(Long id);
    List<Usuario> buscarUsuariosPorNombreOEmail(String nombre, String email) throws NotFoundException;
}