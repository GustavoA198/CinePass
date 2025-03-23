package com.cinePass.CinePass_app.service;

import com.cinePass.CinePass_app.entity.Genero;
import java.util.List;
import java.util.Optional;

public interface GeneroService {

    Genero crearGenero(Genero genero);
    Optional<Genero> obtenerGeneroPorId(Long id);
    List<Genero> obtenerTodosLosGeneros();
    Genero actualizarGenero(Long id, Genero generoActualizado);
    void desactivarGenero(Long id);
    List<Genero> buscarGenerosPorNombre(String nombre);
}