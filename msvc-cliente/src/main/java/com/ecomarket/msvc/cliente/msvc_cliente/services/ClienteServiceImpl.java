package com.ecomarket.msvc.cliente.msvc_cliente.services;

import com.ecomarket.msvc.cliente.msvc_cliente.dtos.ClienteDTO;
import com.ecomarket.msvc.cliente.msvc_cliente.exceptions.ClienteException;
import com.ecomarket.msvc.cliente.msvc_cliente.model.Cliente;
import com.ecomarket.msvc.cliente.msvc_cliente.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private  ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> findAll(){
        return this.findAll() ;
    }

    @Override
    public Cliente findById(Long id) {
        return this.clienteRepository.findById(id).orElseThrow(
                () -> new ClienteException("el  cliente con id: "+ id + "no existe en el sistema")
        );
    }

    @Override
    public Cliente save(Cliente cliente) {
        return this.clienteRepository.save(cliente) ;
    }
}
