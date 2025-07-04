package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.services;

import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos.DetalleCompraDTO;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.entities.DetalleCompra;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetalleCompraServices {

    List<DetalleCompraDTO> findAll();
    DetalleCompra findById(Long Id);
    DetalleCompra save(DetalleCompra detalleCompra);
    List<DetalleCompra> findByProductoId(Long Id);
    List<DetalleCompra> findByBoletaId(Long Id);

}
