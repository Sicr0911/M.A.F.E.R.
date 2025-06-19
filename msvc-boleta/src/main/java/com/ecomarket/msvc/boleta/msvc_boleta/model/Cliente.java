package com.ecomarket.msvc.boleta.msvc_boleta.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private Long idCliente ;
    private String runCliente ;
    private String nombreCompleto ;
    private String correo ;

}
