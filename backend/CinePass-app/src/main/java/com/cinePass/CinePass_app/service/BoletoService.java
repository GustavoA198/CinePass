package com.cinePass.CinePass_app.service;

import com.cinePass.CinePass_app.entity.Boleto;
import java.util.List;
import java.util.Optional;

public interface BoletoService {
    Boleto crearBoleto(Boleto boleto);
    Optional<Boleto> obtenerBoletoPorId(Long id);
    List<Boleto> obtenerTodosLosBoletos();
    Boleto actualizarBoleto(Long id, Boleto boletoActualizado);
    void desactivarBoleto(Long id);
    List<Boleto> buscarBoletosPorUsuarioOFuncion(Long usuarioId, Long funcionId);
}