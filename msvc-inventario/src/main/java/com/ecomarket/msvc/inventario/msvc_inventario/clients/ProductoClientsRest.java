package com.ecomarket.msvc.inventario.msvc_inventario.clients;

import com.ecomarket.msvc.inventario.msvc_inventario.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-productos", url = "localhost:8004/api/v1/productos")
public interface ProductoClientsRest {

    @GetMapping("/{id}")
    Producto findById(@PathVariable Long id) ;

}
