package com.cinePass.CinePass_app.repository;

import com.cinePass.CinePass_app.entity.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, Long> {
    List<Boleto> findByUsuarioIdOrFuncionId(Long usuarioId, Long funcionId);
}