package com.cinePass.CinePass_app.service.impl;

import com.cinePass.CinePass_app.dto.UsuarioDTO;
import com.cinePass.CinePass_app.entity.Usuario;
import com.cinePass.CinePass_app.error.NotFoundException;
import com.cinePass.CinePass_app.repository.UsuarioRepository;
import com.cinePass.CinePass_app.service.UsuarioService;
import com.cinePass.CinePass_app.enums.EstadoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        // Lógica para crear un usuario
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Long id) throws NotFoundException {
        if (!usuarioRepository.existsById(id)) {
            throw new NotFoundException("Usuario no encontrado");
        }
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        // Lógica para obtener todos los usuarios
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario actualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    if (usuarioDTO.getNombre() != null && !usuarioDTO.getNombre().isBlank()) {
                        usuario.setNombre(usuarioDTO.getNombre());
                    }
                    if (usuarioDTO.getApellido() != null && !usuarioDTO.getApellido().isBlank()) {
                        usuario.setApellido(usuarioDTO.getApellido());
                    }
                    if (usuarioDTO.getEmail() != null && !usuarioDTO.getEmail().isBlank()) {
                        usuario.setEmail(usuarioDTO.getEmail());
                    } else {
                        usuarioDTO.setEmail(usuario.getEmail()); // Asegura que no se sobrescriba con null
                    }
                    if (usuarioDTO.getTelefono() != null && !usuarioDTO.getTelefono().isBlank()) {
                        usuario.setTelefono(usuarioDTO.getTelefono());
                    }
                    if (usuarioDTO.getContrasena() != null && !usuarioDTO.getContrasena().isBlank()) {
                        usuario.setContrasena(usuarioDTO.getContrasena());
                    }
                    if (usuarioDTO.getEstado() != null) {
                        usuario.setEstado(usuarioDTO.getEstado());
                    }
                    if (usuarioDTO.getRol() != null) {
                        usuario.setRol(usuarioDTO.getRol());
                    }

                    return usuarioRepository.save(usuario);
                })
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));
    }


    @Override
    public void desactivarUsuario(Long id) {
        // Lógica para desactivar un usuario (borrado lógico)
        usuarioRepository.findById(id).ifPresent(usuario -> {
            usuario.setEstado(EstadoUsuario.INACTIVO);
            usuarioRepository.save(usuario);
        });
    }

    @Override
    public List<Usuario> buscarUsuariosPorNombreOEmail(String nombre, String email) {
        // Lógica para buscar usuarios por nombre o email
        return usuarioRepository.findByNombreContainingOrEmailContaining(nombre, email);
    }
}