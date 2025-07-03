package com.ecomarket.msvc.boleta.msvc_boleta.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    @JsonIgnore
    private Long id;
    private String runCliente ;
    private String nombreCompleto ;
    private String correo ;

}
