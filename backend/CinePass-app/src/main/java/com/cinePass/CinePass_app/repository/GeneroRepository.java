package com.cinePass.CinePass_app.repository;

import com.cinePass.CinePass_app.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
    List<Genero> findByNombreContaining(String nombre);
}