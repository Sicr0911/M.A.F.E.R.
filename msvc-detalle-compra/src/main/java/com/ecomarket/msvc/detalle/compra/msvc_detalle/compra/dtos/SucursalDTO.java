package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class SucursalDTO {

    private Long idSucursal;
    private String nombre;
    private String direccion;
    private String telefono;

}
