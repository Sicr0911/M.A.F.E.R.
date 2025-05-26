package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.clients;


import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient (name = "msvc-Producto", url = "localhost:8004/api/v1/producto")

public interface ProductoClientsRest {

    @GetMapping("{/id}")
    Producto findById(@PathVariable Long id);

}
