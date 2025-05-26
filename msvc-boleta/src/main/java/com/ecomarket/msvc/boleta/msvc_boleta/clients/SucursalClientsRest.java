package com.ecomarket.msvc.boleta.msvc_boleta.clients;

import com.ecomarket.msvc.boleta.msvc_boleta.model.Sucursal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-sucursal", url = "localhost:8080/api/v1/sucursales")
public interface SucursalClientsRest {

    @GetMapping("/{id}")
    Sucursal findById(@PathVariable Long id);

}
