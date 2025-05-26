package com.ecomarket.msvc.inventario.msvc_inventario.models;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Sucursal {

    private Long idSucursal;
    private String nombre;
    private String direccion;
    private String telefono;

}
