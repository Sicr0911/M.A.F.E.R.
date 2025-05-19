package com.ecomarket.msvc.inventario.msvc_inventario.inventarioservice;

import com.ecomarket.msvc.inventario.msvc_inventario.inventariomodel.Inventario;

import java.util.List;

public interface InventarioService {

    List<Inventario> findAll();
    Inventario findById(Long id) ;
    Inventario save(Inventario inventario);

}
