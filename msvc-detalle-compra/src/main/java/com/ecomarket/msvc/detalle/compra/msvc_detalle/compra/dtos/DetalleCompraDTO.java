package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class DetalleCompraDTO {
    @JsonIgnore
    private Long id;
    private Integer costo ;
    private Integer cantidad ;
    private String producto ;
    private LocalDate fecha ;
    private String comentario ;
    private ProductoDTO idProducto;
    private BoletaDTO idBoleta;

}
