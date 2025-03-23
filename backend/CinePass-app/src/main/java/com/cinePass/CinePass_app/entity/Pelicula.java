package com.cinePass.CinePass_app.entity;

import com.cinePass.CinePass_app.enums.EstadoPelicula;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "peliculas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El slug es obligatorio")
    @Column(nullable = false, unique = true)
    private String slug;

    @NotBlank(message = "El título es obligatorio")
    @Column(nullable = false)
    private String titulo;

    @Column
    private String portada;

    @NotBlank(message = "La duración es obligatoria")
    @Column(nullable = false)
    private String duracion;

    @Column
    private String sinopsis;

    @NotNull(message = "La fecha de estreno es obligatoria")
    @Column(name = "fecha_estreno", nullable = false)
    private Instant fechaEstreno;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPelicula estado = EstadoPelicula.ACTIVA;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    private Instant modifiedAt;


    @ManyToMany
    @JoinTable(
            name = "peliculas_generos",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    private List<Genero> generos = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "peliculas_idiomas",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "idioma_id")
    )
    private List<Idioma> idiomas = new ArrayList<>();

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Funcion> funciones = new ArrayList<>();
}
