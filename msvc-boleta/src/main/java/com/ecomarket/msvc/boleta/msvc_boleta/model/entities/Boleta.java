package com.ecomarket.msvc.boleta.msvc_boleta.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Boleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleta")
    private Long idBoleta;

    @Column(name = "")
    @NotNull(message = "")
    private LocalDateTime HoraBoleta;

    private String Detalle;

    @Column(name ="")
    @NotNull(message ="")
    private ;

    @Column(name ="")
    @NotNull(message ="")
    private ;









}
