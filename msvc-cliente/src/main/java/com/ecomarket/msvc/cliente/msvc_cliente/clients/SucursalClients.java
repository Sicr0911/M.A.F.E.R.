package com.ecomarket.msvc.cliente.msvc_cliente.clients;

import com.ecomarket.msvc.cliente.msvc_cliente.model.Sucursal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-Sucursal", url = "localhost:8085/api/v1/clientes")
public interface SucursalClients {

    @GetMapping
    List<Sucursal> findAll();

    @GetMapping("{id}")
    Sucursal findById(@PathVariable Long id);
}
