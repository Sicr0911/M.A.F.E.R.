package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ClienteDTO {

    private Long idCliente ;
    private Long runCliente ;
    private Long nombreCompleto ;
    private Long correo ;

}
