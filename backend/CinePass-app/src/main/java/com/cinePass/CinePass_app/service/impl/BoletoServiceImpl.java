package com.cinePass.CinePass_app.service.impl;

import com.cinePass.CinePass_app.entity.Boleto;
import com.cinePass.CinePass_app.enums.EstadoBoleto;
import com.cinePass.CinePass_app.error.NotFoundException;
import com.cinePass.CinePass_app.repository.BoletoRepository;
import com.cinePass.CinePass_app.service.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletoServiceImpl implements BoletoService {

    @Autowired
    private BoletoRepository boletoRepository;

    @Override
    public Boleto crearBoleto(Boleto boleto) {
        return boletoRepository.save(boleto);
    }

    @Override
    public Optional<Boleto> obtenerBoletoPorId(Long id) {
        if (!boletoRepository.existsById(id)) {
            throw new NotFoundException("Usuario no encontrado");
        }
        return boletoRepository.findById(id);
    }

    @Override
    public List<Boleto> obtenerTodosLosBoletos() {
        return boletoRepository.findAll();
    }

    @Override
    public Boleto actualizarBoleto(Long id, Boleto boletoActualizado) {
        return boletoRepository.findById(id)
                .map(boleto -> {
                    boleto.setCantidad(boletoActualizado.getCantidad());
                    boleto.setPrecioTotal(boletoActualizado.getPrecioTotal());
                    boleto.setMetodoPago(boletoActualizado.getMetodoPago());
                    boleto.setFechaCompra(boletoActualizado.getFechaCompra());
                    boleto.setEstado(boletoActualizado.getEstado());
                    return boletoRepository.save(boleto);
                })
                .orElseThrow(() -> new NotFoundException("Boleto no encontrado"));
    }

    @Override
    public void desactivarBoleto(Long id) {
        boletoRepository.findById(id).ifPresent(boleto -> {
            boleto.setEstado(EstadoBoleto.CANCELADO);
            boletoRepository.save(boleto);
        });
    }

    @Override
    public List<Boleto> buscarBoletosPorUsuarioOFuncion(Long usuarioId, Long funcionId) {
        return boletoRepository.findByUsuarioIdOrFuncionId(usuarioId, funcionId);
    }
}