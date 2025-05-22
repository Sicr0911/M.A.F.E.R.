package com.ecomarket.msvc.cliente.msvc_cliente.services;

import com.ecomarket.msvc.cliente.msvc_cliente.model.entities.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll() ;
    Cliente findById(Long id) ;
    Cliente save(Cliente cliente);

}
