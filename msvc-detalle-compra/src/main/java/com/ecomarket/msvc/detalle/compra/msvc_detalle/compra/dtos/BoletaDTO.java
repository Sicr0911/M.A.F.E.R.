package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class BoletaDTO {

    @JsonIgnore
    private Long id;
    private LocalDateTime HoraBoleta;
    private Integer Costo;
    private String Detalle;

}
