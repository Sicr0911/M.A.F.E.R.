package com.ecomarket.msvc.boleta.msvc_boleta.services;

import java.util.List;

public interface BoletaService {

    List<Boleta> findAll() ;
    Boleta findById(Long id) ;
    Boleta save(Boleta boleta) ;
}
