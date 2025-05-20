package com.ecomarket.msvc.inventario.msvc_inventario.services;

import com.ecomarket.msvc.inventario.msvc_inventario.models.Inventario;

import java.util.List;

public interface InventarioService {

    List<Inventario> findAll();
    Inventario findById(Long id) ;
    Inventario save(Inventario inventario);

}
