package com.ecomarket.msvc.inventario.msvc_inventario.clients;

import com.ecomarket.msvc.inventario.msvc_inventario.models.Producto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductoClientsRest {

    @GetMapping("/{id}")
    Producto findById(@PathVariable Long id) ;

}
