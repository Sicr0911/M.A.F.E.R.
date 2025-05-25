package com.ecomarket.msvc.cliente.msvc_cliente.clients;

import com.ecomarket.msvc.cliente.msvc_cliente.model.entities.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-Cliente", url = "localhost:8083/api/v1/clientes")
public interface ClienteClients {

    @GetMapping("/{id}")
    Cliente findById(@PathVariable Long id);
}
