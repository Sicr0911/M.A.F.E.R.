package com.ecomarket.msvc.boleta.msvc_boleta.model.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "boleta")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Boleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleta", unique = true, nullable = false)
    private Long idBoleta;

    @Column(name = "hora_boleta",  nullable = false)
    private LocalDateTime HoraBoleta;

    private String Detalle;

}