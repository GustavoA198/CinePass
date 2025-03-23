package com.cinePass.CinePass_app.repository;

import com.cinePass.CinePass_app.entity.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Long> {
    List<Idioma> findByNombreContaining(String nombre);
}