package com.ecomarket.msvc.sucursal.msvc.sucursal.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Inventario {

    private Long idInventario;
    private Integer costo;
    private String comentario;
    private Long idBoleta;
    private Long idCliente;

}
