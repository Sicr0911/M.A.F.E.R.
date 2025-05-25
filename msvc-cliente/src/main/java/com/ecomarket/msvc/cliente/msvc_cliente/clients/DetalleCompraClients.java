package com.ecomarket.msvc.cliente.msvc_cliente.clients;

import com.ecomarket.msvc.cliente.msvc_cliente.model.DetalleCompra;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-Cliente", url = "localhost:8084/api/v1/DetalleCompra")
public interface DetalleCompraClients {

    @GetMapping("/{id}")
    List<DetalleCompra> findByIdDetalleCompra(@PathVariable Long id);
}
