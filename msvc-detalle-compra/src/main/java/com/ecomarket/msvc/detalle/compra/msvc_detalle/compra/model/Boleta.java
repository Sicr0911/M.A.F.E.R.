package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Boleta {

    private Long idBoleta;
    private LocalDateTime HoraBoleta;
    private String Detalle;

}
