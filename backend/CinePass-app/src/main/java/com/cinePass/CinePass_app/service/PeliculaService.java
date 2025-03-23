package com.cinePass.CinePass_app.service;

import com.cinePass.CinePass_app.entity.Pelicula;
import com.cinePass.CinePass_app.error.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface PeliculaService {

    Pelicula crearPelicula(Pelicula pelicula);
    Optional<Pelicula> obtenerPeliculaPorId(Long id) throws NotFoundException;
    List<Pelicula> obtenerTodasLasPeliculas();
    Pelicula actualizarPelicula(Long id, Pelicula peliculaActualizada) throws NotFoundException;
    void desactivarPelicula(Long id);
    List<Pelicula> buscarPeliculasPorTituloOGenero(String titulo, String genero) throws NotFoundException;
}