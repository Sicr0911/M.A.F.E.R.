package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Producto {

    private Long idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private String precioProducto;

}
