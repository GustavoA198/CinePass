package com.cinePass.CinePass_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "metodos_pago")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del método de pago es obligatorio")
    @Column(nullable = false)
    private String nombre;

    @Column
    private String icono;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    private Instant modifiedAt;

    // Relaciones

    @OneToMany(mappedBy = "metodoPago", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Boleto> boletos = new ArrayList<>();

}
