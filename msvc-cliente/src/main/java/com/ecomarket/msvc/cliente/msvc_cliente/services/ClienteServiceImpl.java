package com.ecomarket.msvc.cliente.msvc_cliente.services;

import com.ecomarket.msvc.cliente.msvc_cliente.clients.ClienteClients;
import com.ecomarket.msvc.cliente.msvc_cliente.clients.DetalleCompraClients;
import com.ecomarket.msvc.cliente.msvc_cliente.clients.SucursalClients;
import com.ecomarket.msvc.cliente.msvc_cliente.dtos.BoletaDTO;
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
    public List<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return this.clienteRepository.findById(id).orElseThrow(
                () -> new ClienteException("El cliente con id "+id+" no se encuentra de la base de datos")
        );
    }

    @Override
    public Cliente save(Cliente cliente) {
        try {
            Sucursal sucursal = this.sucursalClients.findById(cliente.getIdSucursal());
            return this.clienteRepository.save(cliente);
        }catch (FeignException ex){
            throw new ClienteException(ex.getMessage());
        }
    }

    @Override
    public List<DetalleCompraDTO> findDetalleCompraId(Long IdCliente){
        Cliente cliente = this.clienteClients.findById(IdCliente);

        List<DetalleCompra> detalleCompras = this.detalleCompraClients.findByIdDetalleCompra(IdCliente);
        if (!detalleCompras.isEmpty()){
            return detalleCompras.stream().map(detalleCompra -> {
                DetalleCompraDTO dto = new DetalleCompraDTO();
                Cliente cliente = null;
                try{
                    cliente = this.clienteClients.findById(detalleCompra.getIdDetalleCompra());
                }catch (FeignException ex){
                    throw new ClienteException("Al momento de generar la vista del detalle de compra no"+
                            "se puede encontrar el cliente con id "+IdCliente);
                }
                DetalleCompraDTO compraDTO = new DetalleCompraDTO();
                detalleCompra.setIdDetalleCompra(detalleCompra.getIdDetalleCompra());
                detalleCompra.setPrecio(detalleCompra.getPrecio());
                detalleCompra.setIdProducto(detalleCompra.getIdProducto());
                detalleCompra.setCantTotal(detalleCompra.getCantTotal());
                detalleCompra.setFecha(detalleCompra.getFecha());
                detalleCompra.setIdBoleta(detalleCompra.getIdBoleta());


                dto.setIdProducto(detalleCompra.getIdProducto());
                dto.setIdCliente(cliente.getIdCliente());
                return dto;
            }).toList();
        }
        return List.of();
    }
}
