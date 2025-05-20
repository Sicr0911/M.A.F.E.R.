package com.ecomarket.msvc.inventario.msvc_inventario.models;

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
