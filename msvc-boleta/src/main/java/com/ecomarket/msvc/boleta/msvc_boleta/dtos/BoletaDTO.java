package com.ecomarket.msvc.boleta.msvc_boleta.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class BoletaDTO {

    private LocalDateTime HoraBoleta;
    private Integer Costo;
    private String Detalle;
    private DetalleCompraDTO DetalleCompra;
    private SucursalDTO Sucursal;

}
