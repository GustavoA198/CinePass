package com.cinePass.CinePass_app.service;

import com.cinePass.CinePass_app.entity.Funcion;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface FuncionService {

    Funcion crearFuncion(Funcion funcion);
    Optional<Funcion> obtenerFuncionPorId(Long id);
    List<Funcion> obtenerTodasLasFunciones();
    Funcion actualizarFuncion(Long id, Funcion funcionActualizada);
    void desactivarFuncion(Long id);
    List<Funcion> buscarFuncionesPorPeliculaOHorario(Long peliculaId, Instant horario);

}