package com.ecomarket.msvc.producto.service;

import com.ecomarket.msvc.producto.models.entities.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> findAll();
    producto findById(Long id);
    Producto save(producto producto);

}
