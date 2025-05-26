package com.ecomarket.msvc.boleta.msvc_boleta.dtos;

import lombok.*;

@Getter @Setter
@ToString @AllArgsConstructor @NoArgsConstructor
public class SucursalDTO {

    private Long idSucursal;
    private String nombreSucursal;
    private String Direccion;
    private String telefono;
}
