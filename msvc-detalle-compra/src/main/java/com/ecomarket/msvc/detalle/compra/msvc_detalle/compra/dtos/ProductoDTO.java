package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos;

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
