package com.ecomarket.msvc.cliente.msvc_cliente.dtos;

import lombok.*;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class DetalleCompraDTO {

    private Long idCompra;
    private Long idCliente;
    private Long idProducto;
}
