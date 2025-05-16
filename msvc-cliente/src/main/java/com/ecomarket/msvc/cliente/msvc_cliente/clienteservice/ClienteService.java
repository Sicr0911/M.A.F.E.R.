package com.ecomarket.msvc.cliente.msvc_cliente.clienteservice;

import com.ecomarket.msvc.cliente.msvc_cliente.clientemodel.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll() ;
    Cliente findById(Long id) ;
    Cliente save(Cliente cliente);

}
