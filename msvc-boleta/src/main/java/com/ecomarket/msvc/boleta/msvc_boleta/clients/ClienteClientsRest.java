package com.ecomarket.msvc.boleta.msvc_boleta.clients;

import com.ecomarket.msvc.boleta.msvc_boleta.model.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-cliente", url = "localhost:8081/api/v1/clientes")
public interface ClienteClientsRest {

    @GetMapping("/{id}")
    Cliente findById(@PathVariable Long id);

}
