package com.ecomarket.msvc.cliente.msvc_cliente.services;

import com.ecomarket.msvc.cliente.msvc_cliente.clients.ClienteClients;
import com.ecomarket.msvc.cliente.msvc_cliente.clients.DetalleCompraClients;
import com.ecomarket.msvc.cliente.msvc_cliente.clients.SucursalClients;
import com.ecomarket.msvc.cliente.msvc_cliente.dtos.BoletaDTO;
import com.ecomarket.msvc.cliente.msvc_cliente.dtos.ClienteDTO;
import com.ecomarket.msvc.cliente.msvc_cliente.dtos.DetalleCompraDTO;
import com.ecomarket.msvc.cliente.msvc_cliente.exceptions.ClienteException;
import com.ecomarket.msvc.cliente.msvc_cliente.model.DetalleCompra;
import com.ecomarket.msvc.cliente.msvc_cliente.model.Sucursal;
import com.ecomarket.msvc.cliente.msvc_cliente.model.entities.Cliente;
import com.ecomarket.msvc.cliente.msvc_cliente.repositories.ClienteRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private  ClienteRepository clienteRepository;

    @Autowired
    private ClienteClients clienteClients;

    @Autowired
    private DetalleCompraClients detalleCompraClients;

    @Autowired
    private SucursalClients sucursalClients;

    @Override
    public List<ClienteDTO> findAll(){
        return this.clienteRepository.findAll().stream().map(cliente -> {
            DetalleCompra detalleCompra = null;

            try{
                detalleCompra = this.detalleCompraClients.findById(cliente.getIdCliente());
            }catch (FeignException ex){
                throw new ClienteException("El cliente no existe en el sistema");
            }
        })
    }


}
