package com.cinePass.CinePass_app.controller;

import com.cinePass.CinePass_app.config.JwtService;
import com.cinePass.CinePass_app.controller.models.AuthResponse;
import com.cinePass.CinePass_app.controller.models.AuthenticationRequest;
import com.cinePass.CinePass_app.controller.models.RegisterRequest;
import com.cinePass.CinePass_app.entity.Usuario;
import com.cinePass.CinePass_app.service.Authservice;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private Authservice authService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@Valid @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @GetMapping("/check-status")
    public ResponseEntity<Boolean> checkStatus(@Valid @RequestParam String token) {
        return ResponseEntity.ok(jwtService.isTokenExpiredValid(token));
    }
}
