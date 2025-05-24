package com.ecomarket.msvc.producto.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ProductoDTO {

    private Long idProducto;
    private String nombre;
    private String descripcion;
    private Long stock;

}
