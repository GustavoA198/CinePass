package com.cinePass.CinePass_app.service;

import com.cinePass.CinePass_app.controller.models.AuthResponse;
import com.cinePass.CinePass_app.controller.models.AuthenticationRequest;
import com.cinePass.CinePass_app.controller.models.RegisterRequest;

public interface Authservice {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate(AuthenticationRequest request);
}
