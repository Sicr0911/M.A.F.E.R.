package com.ecomarket.msvc.boleta.msvc_boleta.dtos;

import com.ecomarket.msvc.boleta.msvc_boleta.model.Sucursal;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class DetalleCompraDTO {

    private Integer costo ;
    private Integer cant ;
    private String producto ;
    private Date fecha ;
    private String comentario ;
    private Long idSucursal ;

}
