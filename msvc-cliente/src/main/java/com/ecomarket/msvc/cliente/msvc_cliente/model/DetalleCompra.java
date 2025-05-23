package com.ecomarket.msvc.cliente.msvc_cliente.model;

import lombok.*;

import java.util.Date;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class DetalleCompra {

    private Long idDetalleCompra;
    private Integer cantTotal;
    private Integer precio;
    private String producto ;
    private Long idBoleta;
    private Long idProducto;
    private Date fecha;

}
