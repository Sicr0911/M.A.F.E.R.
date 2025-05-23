package com.ecomarket.msvc.inventario.msvc_inventario.dtos;
import lombok.*;


@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class SucursalDTO {

    private Long idSucursal;
    private String nombreSucursal;
    private String direccionSucursal;
    private String telefonoSucursal;
}
