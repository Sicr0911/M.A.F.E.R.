package com.ecomarket.msvc.cliente.msvc_cliente.services;

import com.ecomarket.msvc.cliente.msvc_cliente.dtos.FichaClienteDTO;
import com.ecomarket.msvc.cliente.msvc_cliente.exceptions.FichaClienteExeption;
import com.ecomarket.msvc.cliente.msvc_cliente.model.entities.Cliente;
import com.ecomarket.msvc.cliente.msvc_cliente.repositories.FichaCliente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaClienteServiceImpl {

    @Autowired
    private FichaCliente fichaCliente;

    @Autowired
    private ClienteService clienteService;

    @Transactional(readOnly = true)
    @Override
    public List<FichaCliente> findAll(){return this.fichaCliente.findAll();}

    @Transactional(readOnly = true)
    @Override
    public FichaCliente findbyId(Long id){
        return FichaCliente.findbyId(id).orElseThrow(
                () -> new FichaClienteExeption("FichaCliente con id "+id+" no encontrada")
        );
    }

    @Transactional
    @Override
    public FichaCliente save(FichaClienteDTO fichaCliente){
        Cliente cliente = this.clienteService.findById(fichaCliente.getIdCliente());
        FichaCliente fichaClienteEntity = new FichaCliente();
        fichaClienteEntity.setCliente(cliente);
        fichaClienteEntity.setdatosPersonales(fichaCliente.getDatosPersonales());
        return this.fichaClienteRepository.save(fichaClienteEntity);
    }
}
