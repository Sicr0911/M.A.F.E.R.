package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.Model;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class DetalleCompra {

    private Long IdDetalleCompra;
    private Long CantTotal;
    private Long Precio;
    private Long IdBoleta;
}
