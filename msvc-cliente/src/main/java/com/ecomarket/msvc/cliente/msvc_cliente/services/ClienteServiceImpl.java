package com.ecomarket.msvc.cliente.msvc_cliente.services;

import com.ecomarket.msvc.cliente.msvc_cliente.exceptions.ClienteException;
import com.ecomarket.msvc.cliente.msvc_cliente.model.entities.Cliente;
import com.ecomarket.msvc.cliente.msvc_cliente.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClienteServiceImpl implements ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return this.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return this.clienteRepository.findById(id).orElseThrow(
                () -> new ClienteException("El cliente con el id: " + id + "no existe")
        );
    }

    @Override
    public Cliente save(Cliente cliente) {
        return null;
    }

}
