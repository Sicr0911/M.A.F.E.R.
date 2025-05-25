package com.ecomarket.msvc.boleta.msvc_boleta.services;

import com.ecomarket.msvc.boleta.msvc_boleta.dtos.BoletaDTO;
import com.ecomarket.msvc.boleta.msvc_boleta.model.entities.Boleta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoletaService {

    List<BoletaDTO> findAll();
    Boleta findById(Long id) ;
    Boleta save(Boleta boleta) ;
    List<Boleta>  findBySucursalId (Long sucursalId) ;
    List<Boleta>  findByClienteId (Long clienteId) ;
    List<Boleta>  findByDetalleCompraId (Long detalleCompraId) ;
}
