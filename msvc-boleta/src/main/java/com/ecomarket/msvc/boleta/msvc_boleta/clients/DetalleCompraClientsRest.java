package com.ecomarket.msvc.boleta.msvc_boleta.clients;

import com.ecomarket.msvc.boleta.msvc_boleta.model.DetalleCompra;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-detalle-compra", url = "localhost:8002/api/v1/detallecompra")
public interface DetalleCompraClientsRest {

    @GetMapping("/{id}")
    DetalleCompra findById(@PathVariable Long id);

}
