package com.ecomarket.msvc.cliente.msvc_cliente.services;

import com.ecomarket.msvc.cliente.msvc_cliente.dtos.ClienteDTO;
import com.ecomarket.msvc.cliente.msvc_cliente.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {

    List<ClienteDTO> findAll() ;
    Cliente findById(Long id) ;
    Cliente save(Cliente cliente);
}
