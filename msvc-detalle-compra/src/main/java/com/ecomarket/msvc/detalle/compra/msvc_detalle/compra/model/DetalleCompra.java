package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model;

import jakarta.persistence.*;
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
