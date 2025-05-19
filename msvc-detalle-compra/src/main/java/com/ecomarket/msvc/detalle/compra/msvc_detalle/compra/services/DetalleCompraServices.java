package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.services;

import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.Model.DetalleCompra;

import java.util.List;

public interface DetalleCompraServices {

    DetalleCompra findbyId(Long Id);
    DetalleCompra save(DetalleCompra detalleCompra);
    List<DetalleCompra> findByDetalleCompra(Long IdDetalleCompra);
}
