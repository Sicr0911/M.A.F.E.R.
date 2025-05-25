package com.ecomarket.msvc.cliente.msvc_cliente.services;

import com.ecomarket.msvc.cliente.msvc_cliente.dtos.FichaClienteDTO;
import com.ecomarket.msvc.cliente.msvc_cliente.exceptions.FichaClienteExeption;
import com.ecomarket.msvc.cliente.msvc_cliente.model.entities.Cliente;
import com.ecomarket.msvc.cliente.msvc_cliente.model.entities.FichaCliente;
import com.ecomarket.msvc.cliente.msvc_cliente.repositories.FichaClienteRepisitory;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaClienteServiceImpl implements FichaClienteService {

    @Autowired
    private FichaClienteRepisitory fichaClienteRepisitory;

    @Autowired
    private ClienteService clienteService;

    @Transactional(readOnly = true)
    public List<FichaClienteRepisitory> findAll(){
        return this.fichaClienteRepisitory.findAll();
    }

    @Transactional(readonly = true)
    @Override
    public FichaClienteRepisitory findById(Long id){
        return this.fichaClienteRepisitory.findById(id).orElseThrow(
                () -> new FichaClienteExeption("Ficha Cliente no encontrado "+id)
        );
    }

    @Transactional
    @Override
    public FichaCliente save(FichaClienteDTO fichaCliente){
        Cliente cliente = this.clienteService.findById(fichaCliente.getIdCliente());
        FichaCliente fichaClienteEntity = new FichaCliente();
        fichaClienteEntity.setCliente(cliente);
        fichaClienteEntity.setDatosPersonales(fichaCliente.getDatosPersonales());
        return this.fichaClienteRepisitory.save(fichaClienteEntity);
    }
}
