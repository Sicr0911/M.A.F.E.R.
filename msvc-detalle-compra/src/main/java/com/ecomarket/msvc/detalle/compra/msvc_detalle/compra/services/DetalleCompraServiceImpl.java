package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.services;

import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.DetalleCompra;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.exceptions.DetalleCompraException;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.repositories.DetalleCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraServices{

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Override
    public List<DetalleCompra> findAll() {
        return this.findAll();
    }

    @Override
    public DetalleCompra findbyId(Long id) {
        return this.detalleCompraRepository.findById(id).orElseThrow(
            () -> new DetalleCompraException("El detalle con el id:" + id + "no existe")
        );
    }

    @Override
    public DetalleCompra save(DetalleCompra detalleCompra) {
        return null;
    }

}
