package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class BoletaDTO {

    private Long idBoleta;
    private LocalDateTime HoraBoleta;
    private String Detalle;

}
