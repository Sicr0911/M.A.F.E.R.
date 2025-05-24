package com.ecomarket.msvc.producto.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class InventarioDTO {

    private Long idInventario;
    private Integer costo;
    private String comentario;
    private Long idBoleta;
    private Long idCliente;

}
