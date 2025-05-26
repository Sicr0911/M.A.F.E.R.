package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class DetalleCompraDTO {

    private Integer costo ;
    private Integer cantidad ;
    private String producto ;
    private Date fecha ;
    private String comentario ;
    private ProductoDTO idProducto;
    private BoletaDTO idBoleta;

}
