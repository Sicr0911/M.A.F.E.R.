package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.services;

import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.DetalleCompra;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetalleCompraServices {

    List<DetalleCompra> findAll();
    DetalleCompra findbyId(Long Id);
    DetalleCompra save(DetalleCompra detalleCompra);

}
