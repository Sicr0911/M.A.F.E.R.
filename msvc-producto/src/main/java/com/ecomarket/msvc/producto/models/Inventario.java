package com.ecomarket.msvc.producto.models;

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
