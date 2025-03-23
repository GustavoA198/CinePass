package com.cinePass.CinePass_app.controller;

import com.cinePass.CinePass_app.entity.Boleto;
import com.cinePass.CinePass_app.service.BoletoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/boletos")
public class BoletoController {

    @Autowired
    private BoletoService boletoService;

    @PostMapping
    public ResponseEntity<Boleto> crearBoleto(@Valid @RequestBody Boleto boleto) {
        Boleto nuevoBoleto = boletoService.crearBoleto(boleto);
        return ResponseEntity.ok(nuevoBoleto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Boleto>> obtenerBoletoPorId(@PathVariable Long id) {
        Optional<Boleto> boleto = boletoService.obtenerBoletoPorId(id);
        return ResponseEntity.ok(boleto);
    }

    @GetMapping
    public ResponseEntity<List<Boleto>> obtenerTodosLosBoletos() {
        List<Boleto> boletos = boletoService.obtenerTodosLosBoletos();
        return ResponseEntity.ok(boletos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boleto> actualizarBoleto(@PathVariable Long id, @Valid @RequestBody Boleto boletoActualizado) {
        Boleto boleto = boletoService.actualizarBoleto(id, boletoActualizado);
        return ResponseEntity.ok(boleto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desactivarBoleto(@PathVariable Long id) {
        boletoService.desactivarBoleto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Boleto>> buscarBoletosPorUsuarioOFuncion(
            @RequestParam(required = false) Long usuarioId,
            @RequestParam(required = false) Long funcionId) {
        List<Boleto> boletos = boletoService.buscarBoletosPorUsuarioOFuncion(usuarioId, funcionId);
        return ResponseEntity.ok(boletos);
    }
}