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
@Table(name = "idiomas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del idioma es obligatorio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El codigo en ISO 639-1 del idioma es obligatorio")
    @Column(nullable = false)
    private String codigoIdioma;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    private Instant modifiedAt;

    // Relaciones

    @ManyToMany(mappedBy = "idiomas")
    private List<Pelicula> peliculas = new ArrayList<>();
}
