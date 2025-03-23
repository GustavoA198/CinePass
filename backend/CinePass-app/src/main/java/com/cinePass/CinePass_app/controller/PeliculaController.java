package com.cinePass.CinePass_app.controller;

import com.cinePass.CinePass_app.entity.Pelicula;
import com.cinePass.CinePass_app.service.PeliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @PostMapping
    public ResponseEntity<Pelicula> crearPelicula(@Valid @RequestBody Pelicula pelicula) {
        Pelicula nuevaPelicula = peliculaService.crearPelicula(pelicula);
        return ResponseEntity.ok(nuevaPelicula);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pelicula>> obtenerPeliculaPorId(@PathVariable Long id) {
        Optional<Pelicula> pelicula = peliculaService.obtenerPeliculaPorId(id);
        return ResponseEntity.ok(pelicula);
    }

    @GetMapping
    public ResponseEntity<List<Pelicula>> obtenerTodasLasPeliculas() {
        List<Pelicula> peliculas = peliculaService.obtenerTodasLasPeliculas();
        return ResponseEntity.ok(peliculas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizarPelicula(@PathVariable Long id, @Valid @RequestBody Pelicula peliculaActualizada) {
        Pelicula pelicula = peliculaService.actualizarPelicula(id, peliculaActualizada);
        return ResponseEntity.ok(pelicula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desactivarPelicula(@PathVariable Long id) {
        peliculaService.desactivarPelicula(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Pelicula>> buscarPeliculasPorTituloOGenero(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String genero) {
        List<Pelicula> peliculas = peliculaService.buscarPeliculasPorTituloOGenero(titulo, genero);
        return ResponseEntity.ok(peliculas);
    }
}