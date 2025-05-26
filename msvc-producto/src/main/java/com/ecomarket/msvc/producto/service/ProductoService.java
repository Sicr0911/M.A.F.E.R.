package com.ecomarket.msvc.producto.service;


import com.ecomarket.msvc.producto.models.entities.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductoService {

    List<Producto> findAll();
    Producto findById(Long id);
    Producto save(Producto producto);

}
