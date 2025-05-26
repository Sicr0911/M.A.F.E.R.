package com.ecomarket.msvc.inventario.msvc_inventario.models;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Producto {

    private Long idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private String precioProducto;

}
