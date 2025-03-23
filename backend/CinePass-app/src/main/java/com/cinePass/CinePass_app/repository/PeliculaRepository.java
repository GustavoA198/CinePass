package com.cinePass.CinePass_app.repository;

import com.cinePass.CinePass_app.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    List<Pelicula> findByTituloContainingOrGenerosNombreContaining(String titulo, String genero);
}