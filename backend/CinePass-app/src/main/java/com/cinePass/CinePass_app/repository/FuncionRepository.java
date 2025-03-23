package com.cinePass.CinePass_app.repository;

import com.cinePass.CinePass_app.entity.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Long> {
    List<Funcion> findByPeliculaIdOrHorario(Long peliculaId, Instant horario);
}