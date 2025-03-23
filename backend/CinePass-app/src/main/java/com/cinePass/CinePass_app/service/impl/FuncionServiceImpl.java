package com.cinePass.CinePass_app.service.impl;

import com.cinePass.CinePass_app.entity.Funcion;
import com.cinePass.CinePass_app.enums.EstadoFuncion;
import com.cinePass.CinePass_app.error.NotFoundException;
import com.cinePass.CinePass_app.repository.FuncionRepository;
import com.cinePass.CinePass_app.service.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionServiceImpl implements FuncionService {

    @Autowired
    private FuncionRepository funcionRepository;

    @Override
    public Funcion crearFuncion(Funcion funcion) {
        return funcionRepository.save(funcion);
    }

    @Override
    public Optional<Funcion> obtenerFuncionPorId(Long id) {
        if (!funcionRepository.existsById(id)) {
            throw new NotFoundException("Función no encontrada");
        }
        return funcionRepository.findById(id);
    }

    @Override
    public List<Funcion> obtenerTodasLasFunciones() {
        return funcionRepository.findAll();
    }

    @Override
    public Funcion actualizarFuncion(Long id, Funcion funcionActualizada) {
        return funcionRepository.findById(id)
                .map(funcion -> {
                    funcion.setHorario(funcionActualizada.getHorario());
                    funcion.setPrecio(funcionActualizada.getPrecio());
                    funcion.setBoletosDisponibles(funcionActualizada.getBoletosDisponibles());
                    return funcionRepository.save(funcion);
                })
                .orElseThrow(() -> new NotFoundException("Función no encontrada"));
    }

    @Override
    public void desactivarFuncion(Long id) {
        funcionRepository.findById(id).ifPresent(funcion -> {
            funcion.setEstado(EstadoFuncion.INACTIVA);
            funcionRepository.save(funcion);
        });
    }

    @Override
    public List<Funcion> buscarFuncionesPorPeliculaOHorario(Long peliculaId, Instant horario) {
        return funcionRepository.findByPeliculaIdOrHorario(peliculaId, horario);
    }
}