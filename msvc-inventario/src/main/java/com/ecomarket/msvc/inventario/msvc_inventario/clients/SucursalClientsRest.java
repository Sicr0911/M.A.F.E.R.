package com.ecomarket.msvc.inventario.msvc_inventario.clients;

import com.ecomarket.msvc.inventario.msvc_inventario.models.Sucursal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-sucursal", url = "localhost:8003/api/v1/sucursales")
public interface SucursalClientsRest {

    @GetMapping("/{id}")
    Sucursal findById(@PathVariable Long id);

}
