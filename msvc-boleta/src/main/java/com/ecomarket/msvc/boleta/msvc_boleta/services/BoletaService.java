package com.ecomarket.msvc.boleta.msvc_boleta.services;

import com.ecomarket.msvc.boleta.msvc_boleta.dtos.BoletaDTO;
import com.ecomarket.msvc.boleta.msvc_boleta.model.entities.Boleta;

import java.util.List;

public interface BoletaService {

    List<BoletaDTO> findAll();
    Boleta findById(Long id) ;
    Boleta save(Boleta boleta) ;
    List<Boleta> findByIdDetalleCompra(Long DetalleCompra);
    List<Boleta> findByIdSucursal(Long IdSucursal);

}
