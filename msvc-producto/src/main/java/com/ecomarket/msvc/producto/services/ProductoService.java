package com.ecomarket.msvc.producto.services;

import java.util.List;

public interface ProductoService {

    List<Producto> findAll();
    Producto findById(Long id) ;
    Producto save(Prducto producto);

}
