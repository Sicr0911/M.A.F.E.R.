package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.clients;

import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.Boleta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient (name = "msvc-boleta", url = "localhost:8005/api/v1/boleta")

public interface BoletaClientsRest {
    @GetMapping("/{id}")
    Boleta findById(@PathVariable Long id);

}
