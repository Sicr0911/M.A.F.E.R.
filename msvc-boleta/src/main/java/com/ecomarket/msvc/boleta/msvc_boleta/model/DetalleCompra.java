package com.ecomarket.msvc.boleta.msvc_boleta.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class DetalleCompra {

    private Long idDetalleCompra;
    private Integer cant;
    private Integer costo;
    private String producto ;
    private Long idSucursal;
    private LocalDate fecha;
    private String comentario;

}
