package com.ecomarket.msvc.cliente.msvc_cliente.dtos;

import lombok.*;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class ClienteDTO {

    private String nombre;
    private Long Run;
    private String Correo;
}
