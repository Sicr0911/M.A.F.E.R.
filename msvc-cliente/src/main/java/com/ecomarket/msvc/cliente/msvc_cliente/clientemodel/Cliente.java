package com.ecomarket.msvc.cliente.msvc_cliente.clientemodel;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Cliente {

    private Long idCliente ;
    private String runCliente ;
    private String nombreCompleto ;
    private String correo ;

}
