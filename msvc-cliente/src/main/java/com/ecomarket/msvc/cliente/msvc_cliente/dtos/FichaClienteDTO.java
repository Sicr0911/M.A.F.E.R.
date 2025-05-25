package com.ecomarket.msvc.cliente.msvc_cliente.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class FichaClienteDTO {

    @NotBlank(message = "El campo no puede estar vacio")
    private String datosPersonales;

    @NotNull(message = "El campo id Cliente no puede estar vacio")
    private Long IdCliente;
}
