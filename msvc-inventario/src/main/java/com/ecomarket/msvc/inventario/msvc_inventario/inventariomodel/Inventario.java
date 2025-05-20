package com.ecomarket.msvc.inventario.msvc_inventario.inventariomodel;

import lombok.*;

import java.time.LocalDateTime;

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
