package com.cinePass.CinePass_app.repository;

import com.cinePass.CinePass_app.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {}
