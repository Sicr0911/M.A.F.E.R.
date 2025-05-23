package com.ecomarket.msvc.cliente.msvc_cliente.dtos;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class BoletaDTO {

    private LocalDateTime HoraBoleta;
    private Integer Costo;
    private String Detalle;
}
