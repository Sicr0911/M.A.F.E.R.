package com.ecomarket.msvc.sucursal.msvc.sucursal.model;

import lombok.*;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Sucursal {

    private Long idSucursal;
    private String nombre;
    private String direccion;
    private String telefono;

}
