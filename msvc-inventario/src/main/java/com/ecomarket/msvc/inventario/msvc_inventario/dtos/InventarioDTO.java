package com.ecomarket.msvc.inventario.msvc_inventario.dtos;

import com.ecomarket.msvc.inventario.msvc_inventario.models.Producto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class InventarioDTO {

    @JsonIgnore
    private Long id;
    private Integer costo;
    private String producto;
    private String comentario;
    private ProductoDTO idProducto;
    private SucursalDTO idSucursal;

}
