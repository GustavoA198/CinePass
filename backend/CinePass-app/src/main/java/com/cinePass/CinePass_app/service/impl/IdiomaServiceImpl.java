package com.cinePass.CinePass_app.service.impl;

import com.cinePass.CinePass_app.entity.Idioma;
import com.cinePass.CinePass_app.enums.EstadoPelicula;
import com.cinePass.CinePass_app.error.NotFoundException;
import com.cinePass.CinePass_app.repository.IdiomaRepository;
import com.cinePass.CinePass_app.service.IdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdiomaServiceImpl implements IdiomaService {

    @Autowired
    private IdiomaRepository idiomaRepository;

    @Override
    public Idioma crearIdioma(Idioma idioma) {
        return idiomaRepository.save(idioma);
    }

    @Override
    public Optional<Idioma> obtenerIdiomaPorId(Long id) {
        if (!idiomaRepository.existsById(id)) {
            throw new NotFoundException("Idioma no encontrado");
        }
        return idiomaRepository.findById(id);
    }

    @Override
    public List<Idioma> obtenerTodosLosIdiomas() {
        return idiomaRepository.findAll();
    }

    @Override
    public Idioma actualizarIdioma(Long id, Idioma idiomaActualizado) {
        return idiomaRepository.findById(id)
                .map(idioma -> {
                    idioma.setNombre(idiomaActualizado.getNombre());
                    return idiomaRepository.save(idioma);
                })
                .orElseThrow(() -> new RuntimeException("Idioma no encontrado"));
    }

    @Override
    public void desactivarIdioma(Long id) {
//        idiomaRepository.findById(id).ifPresent(idioma -> {
//            idioma.setEstado(EstadoPelicula.INACTIVA);
//            idiomaRepository.save(idioma);
//        });
    }

    @Override
    public List<Idioma> buscarIdiomasPorNombre(String nombre) {
        return idiomaRepository.findByNombreContaining(nombre);
    }
}
