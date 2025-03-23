package com.cinePass.CinePass_app.controller;

import com.cinePass.CinePass_app.entity.Funcion;
import com.cinePass.CinePass_app.service.FuncionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funciones")
public class FuncionController {

    @Autowired
    private FuncionService funcionService;

    @PostMapping
    public ResponseEntity<Funcion> crearFuncion(@Valid @RequestBody Funcion funcion) {
        Funcion nuevaFuncion = funcionService.crearFuncion(funcion);
        return ResponseEntity.ok(nuevaFuncion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Funcion>> obtenerFuncionPorId(@PathVariable Long id) {
        Optional<Funcion> funcion = funcionService.obtenerFuncionPorId(id);
        return ResponseEntity.ok(funcion);
    }

    @GetMapping
    public ResponseEntity<List<Funcion>> obtenerTodasLasFunciones() {
        List<Funcion> funciones = funcionService.obtenerTodasLasFunciones();
        return ResponseEntity.ok(funciones);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcion> actualizarFuncion(@PathVariable Long id, @Valid @RequestBody Funcion funcionActualizada) {
        Funcion funcion = funcionService.actualizarFuncion(id, funcionActualizada);
        return ResponseEntity.ok(funcion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desactivarFuncion(@PathVariable Long id) {
        funcionService.desactivarFuncion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Funcion>> buscarFuncionesPorPeliculaOHorario(
            @RequestParam(required = false) Long peliculaId,
            @RequestParam(required = false) Instant horario) {
        List<Funcion> funciones = funcionService.buscarFuncionesPorPeliculaOHorario(peliculaId, horario);
        return ResponseEntity.ok(funciones);
    }
}