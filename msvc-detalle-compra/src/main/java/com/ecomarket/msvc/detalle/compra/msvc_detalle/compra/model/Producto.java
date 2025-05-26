package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Producto {

    private Long idProducto;
    private String nombre;
    private String descripcion;
    private Long stock;

}
