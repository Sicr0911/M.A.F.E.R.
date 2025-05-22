package com.ecomarket.msvc.inventario.msvc_inventario.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class InventarioDTO {

    private Integer costo;
    private String producto;
    private String comentario;

}
