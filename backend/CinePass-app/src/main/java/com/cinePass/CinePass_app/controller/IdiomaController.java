package com.cinePass.CinePass_app.controller;

import com.cinePass.CinePass_app.entity.Idioma;
import com.cinePass.CinePass_app.service.IdiomaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/idiomas")
public class IdiomaController {

    @Autowired
    private IdiomaService idiomaService;

    @PostMapping
    public ResponseEntity<Idioma> crearIdioma(@Valid @RequestBody Idioma idioma) {
        Idioma nuevoIdioma = idiomaService.crearIdioma(idioma);
        return ResponseEntity.ok(nuevoIdioma);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Idioma>> obtenerIdiomaPorId(@PathVariable Long id) {
        Optional<Idioma> idioma = idiomaService.obtenerIdiomaPorId(id);
        return ResponseEntity.ok(idioma);
    }

    @GetMapping
    public ResponseEntity<List<Idioma>> obtenerTodosLosIdiomas() {
        List<Idioma> idiomas = idiomaService.obtenerTodosLosIdiomas();
        return ResponseEntity.ok(idiomas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Idioma> actualizarIdioma(@PathVariable Long id, @Valid @RequestBody Idioma idiomaActualizado) {
        Idioma idioma = idiomaService.actualizarIdioma(id, idiomaActualizado);
        return ResponseEntity.ok(idioma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desactivarIdioma(@PathVariable Long id) {
        idiomaService.desactivarIdioma(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Idioma>> buscarIdiomasPorNombre(@RequestParam String nombre) {
        List<Idioma> idiomas = idiomaService.buscarIdiomasPorNombre(nombre);
        return ResponseEntity.ok(idiomas);
    }
}