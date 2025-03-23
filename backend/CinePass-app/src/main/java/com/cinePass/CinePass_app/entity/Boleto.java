package com.cinePass.CinePass_app.entity;

import com.cinePass.CinePass_app.enums.EstadoBoleto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Entity
@Table(name = "boletos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "funcion_id", nullable = false)
    private Funcion funcion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Positive(message = "La cantidad debe ser un valor positivo")
    @Column(nullable = false)
    private Integer cantidad;

    @Positive(message = "El precio total debe ser un valor positivo")
    @Column(name = "precio_total", nullable = false)
    private Double precioTotal;

    @ManyToOne
    @JoinColumn(name = "metodo_pago_id", nullable = false)
    private MetodoPago metodoPago;

    @NotNull(message = "La fecha de compra es obligatoria")
    @Column(name = "fecha_compra", nullable = false)
    private Instant fechaCompra;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado es obligatorio")
    @Column(nullable = false)
    private EstadoBoleto estado = EstadoBoleto.PENDIENTE;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    private Instant modifiedAt;

}
