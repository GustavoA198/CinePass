package com.cinePass.CinePass_app.service;

import com.cinePass.CinePass_app.entity.Idioma;
import java.util.List;
import java.util.Optional;

public interface IdiomaService {

    Idioma crearIdioma(Idioma idioma);
    Optional<Idioma> obtenerIdiomaPorId(Long id);
    List<Idioma> obtenerTodosLosIdiomas();
    Idioma actualizarIdioma(Long id, Idioma idiomaActualizado);
    void desactivarIdioma(Long id);
    List<Idioma> buscarIdiomasPorNombre(String nombre);
}