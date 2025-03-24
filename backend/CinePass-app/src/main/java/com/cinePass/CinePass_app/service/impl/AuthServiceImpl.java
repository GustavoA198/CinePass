package com.cinePass.CinePass_app.service.impl;

import com.cinePass.CinePass_app.config.JwtService;
import com.cinePass.CinePass_app.controller.models.AuthResponse;
import com.cinePass.CinePass_app.controller.models.AuthenticationRequest;
import com.cinePass.CinePass_app.controller.models.RegisterRequest;
import com.cinePass.CinePass_app.entity.Usuario;
import com.cinePass.CinePass_app.repository.UsuarioRepository;
import com.cinePass.CinePass_app.service.Authservice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements Authservice {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthResponse register(RegisterRequest request) {
        var checkemail = usuarioRepository.findUsuarioByEmail(request.getEmail());
        System.out.println("EMAIL ->" + checkemail);
        checkemail.ifPresent(usuario -> {
            System.out.println("EMAIL ->");
            throw new RuntimeException("Email ya registrado");
        });
        var usuario = Usuario.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .email(request.getEmail())
                .telefono(request.getTelefono())
                .contrasena(passwordEncoder.encode(request.getContrasena()))
                //.contrasena(request.getContrasena())
                .estado(request.getEstado())
                .rol(request.getRol())
                .build();
        usuarioRepository.save(usuario);
        var jwtToken = jwtService.generateToken(usuario);
        return AuthResponse.builder()
                .token(jwtToken)
                .usuario(usuario).build();
    }

    @Override
    public AuthResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var usuario = usuarioRepository.findUsuarioByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(usuario);
        return AuthResponse.builder()
                .token(jwtToken)
                .usuario(usuario)
                .build();
    }
}
