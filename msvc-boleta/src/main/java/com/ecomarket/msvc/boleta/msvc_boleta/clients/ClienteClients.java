package com.ecomarket.msvc.boleta.msvc_boleta.clients;

import com.ecomarket.msvc.boleta.msvc_boleta.model.Cliente;
import com.ecomarket.msvc.boleta.msvc_boleta.model.entities.Boleta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-boleta", url = "localhost:8082/api/v1/boleta")
public interface ClienteClients {

    @GetMapping("/{id}")
    Cliente findById(@PathVariable Long id);

}
