package com.ecomarket.msvc.boleta.msvc_boleta.services;

import com.ecomarket.msvc.boleta.msvc_boleta.dtos.BoletaDTO;
import com.ecomarket.msvc.boleta.msvc_boleta.model.entities.Boleta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoletaService {

    List<Boleta> findAll();
    Boleta findById(Long id) ;
    Boleta save(Boleta boleta) ;

}
