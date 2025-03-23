package com.cinePass.CinePass_app.service.impl;

import com.cinePass.CinePass_app.entity.Genero;
import com.cinePass.CinePass_app.error.NotFoundException;
import com.cinePass.CinePass_app.repository.GeneroRepository;
import com.cinePass.CinePass_app.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public Genero crearGenero(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    public Optional<Genero> obtenerGeneroPorId(Long id) {
        if (generoRepository.existsById(id)){
            throw new NotFoundException("Género no encontrado");
        }
        return generoRepository.findById(id);
    }

    @Override
    public List<Genero> obtenerTodosLosGeneros() {
        return generoRepository.findAll();
    }

    @Override
    public Genero actualizarGenero(Long id, Genero generoActualizado) {
        return generoRepository.findById(id)
                .map(genero -> {
                    genero.setNombre(generoActualizado.getNombre());
                    return generoRepository.save(genero);
                })
                .orElseThrow(() -> new NotFoundException("Género no encontrado"));
    }

    @Override
    public void desactivarGenero(Long id) {
//        // Lógica para desactivar un género (borrado lógico)
//        generoRepository.findById(id).ifPresent(genero -> {
//            genero.setEstado("INACTIVO");
//            generoRepository.save(genero);
//        });
    }

    @Override
    public List<Genero> buscarGenerosPorNombre(String nombre) {
        // Lógica para buscar géneros por nombre
        return generoRepository.findByNombreContaining(nombre);
    }
}
