package com.ecomarket.msvc.cliente.msvc_cliente.dtos;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Setter @Getter @ToString
public class ProductoDTO {
    
    private String nombre;
    private String descripcion;
    private double precio;
}
