package com.cinePass.CinePass_app.controller;

import com.cinePass.CinePass_app.entity.Genero;
import com.cinePass.CinePass_app.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @PostMapping
    public ResponseEntity<Genero> crearGenero(@RequestBody Genero genero) {
        Genero nuevoGenero = generoService.crearGenero(genero);
        return ResponseEntity.ok(nuevoGenero);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Genero>> obtenerGeneroPorId(@PathVariable Long id) {
        Optional<Genero> genero = generoService.obtenerGeneroPorId(id);
        return ResponseEntity.ok(genero);
    }

    @GetMapping
    public ResponseEntity<List<Genero>> obtenerTodosLosGeneros() {
        List<Genero> generos = generoService.obtenerTodosLosGeneros();
        return ResponseEntity.ok(generos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genero> actualizarGenero(@PathVariable Long id, @RequestBody Genero generoActualizado) {
        Genero genero = generoService.actualizarGenero(id, generoActualizado);
        return ResponseEntity.ok(genero);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desactivarGenero(@PathVariable Long id) {
        generoService.desactivarGenero(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Genero>> buscarGenerosPorNombre(@RequestParam String nombre) {
        List<Genero> generos = generoService.buscarGenerosPorNombre(nombre);
        return ResponseEntity.ok(generos);
    }
}