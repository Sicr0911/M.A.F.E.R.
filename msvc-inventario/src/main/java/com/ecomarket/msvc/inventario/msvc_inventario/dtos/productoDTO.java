package com.ecomarket.msvc.inventario.msvc_inventario.dtos;
import lombok.*;


@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class productoDTO {

    private Long idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private String precioProducto;
}
