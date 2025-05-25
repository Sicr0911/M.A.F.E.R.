package com.ecomarket.msvc.cliente.msvc_cliente.services;

import com.ecomarket.msvc.cliente.msvc_cliente.model.entities.FichaCliente;

import java.util.List;

public interface FichaClienteService {

    List<FichaCliente> findAll();
    FichaCliente findById(Long id);
    FichaCliente save();
}
