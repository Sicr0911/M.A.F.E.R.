package com.ecomarket.msvc.boleta.msvc_boleta.dtos;

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

}
