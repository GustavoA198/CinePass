package com.cinePass.CinePass_app.service.impl;

import com.cinePass.CinePass_app.entity.Pelicula;
import com.cinePass.CinePass_app.enums.EstadoPelicula;
import com.cinePass.CinePass_app.repository.PeliculaRepository;
import com.cinePass.CinePass_app.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Optional<Pelicula> obtenerPeliculaPorId(Long id) {
        return peliculaRepository.findById(id);
    }

    @Override
    public List<Pelicula> obtenerTodasLasPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula actualizarPelicula(Long id, Pelicula peliculaActualizada) {
        return peliculaRepository.findById(id)
                .map(pelicula -> {
                    pelicula.setTitulo(peliculaActualizada.getTitulo());
                    pelicula.setPortada(peliculaActualizada.getPortada());
                    pelicula.setDuracion(peliculaActualizada.getDuracion());
                    pelicula.setSinopsis(peliculaActualizada.getSinopsis());
                    pelicula.setFechaEstreno(peliculaActualizada.getFechaEstreno());
                    pelicula.setEstado(peliculaActualizada.getEstado());
                    return peliculaRepository.save(pelicula);
                })
                .orElseThrow(() -> new RuntimeException("Película no encontrada"));
    }

    @Override
    public void desactivarPelicula(Long id) {
        peliculaRepository.findById(id).ifPresent(pelicula -> {
            pelicula.setEstado(EstadoPelicula.INACTIVA);
            peliculaRepository.save(pelicula);
        });
    }

    @Override
    public List<Pelicula> buscarPeliculasPorTituloOGenero(String titulo, String genero) {
        return peliculaRepository.findByTituloContainingOrGenerosNombreContaining(titulo, genero);
    }
}