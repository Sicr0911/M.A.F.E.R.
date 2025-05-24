package com.ecomarket.msvc.sucursal.msvc.sucursal.dtos;

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