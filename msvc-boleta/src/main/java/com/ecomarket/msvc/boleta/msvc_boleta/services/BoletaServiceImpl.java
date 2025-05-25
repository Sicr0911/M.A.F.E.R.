package com.ecomarket.msvc.boleta.msvc_boleta.services;

import com.ecomarket.msvc.boleta.msvc_boleta.clients.ClienteClients;
import com.ecomarket.msvc.boleta.msvc_boleta.clients.DetalleCompraClients;
import com.ecomarket.msvc.boleta.msvc_boleta.clients.SucursalClients;
import com.ecomarket.msvc.boleta.msvc_boleta.dtos.BoletaDTO;
import com.ecomarket.msvc.boleta.msvc_boleta.dtos.ClienteDTO;
import com.ecomarket.msvc.boleta.msvc_boleta.dtos.DetalleCompraDTO;
import com.ecomarket.msvc.boleta.msvc_boleta.exeptions.BoletaExeption;
import com.ecomarket.msvc.boleta.msvc_boleta.model.Cliente;
import com.ecomarket.msvc.boleta.msvc_boleta.model.DetalleCompra;
import com.ecomarket.msvc.boleta.msvc_boleta.model.Sucursal;
import com.ecomarket.msvc.boleta.msvc_boleta.model.entities.Boleta;
import com.ecomarket.msvc.boleta.msvc_boleta.repositories.BoletaRepositories;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletaServiceImpl implements BoletaService{

    @Autowired
    private BoletaRepositories boletaRepositories;

    @Autowired
    private ClienteClients clienteClients;

    @Autowired
    private DetalleCompraClients detalleCompraClients;

    @Autowired
    private SucursalClients sucursalClients;

    @Override
    public List<BoletaDTO> findAll() {
        return this.boletaRepositories.findAll().stream().map(boleta  -> {

            Cliente cliente = null ;

            try {
                cliente = this.clienteClients.findById(boleta.getIdCliente());
            } catch (FeignException ex) {
                throw new BoletaExeption("El cliente no existe en el sistema");
            }

            DetalleCompra detalleCompra = null ;
            Sucursal sucursal = null ;

            try {
                detalleCompra = this.detalleCompraClients.findById(boleta.getIdDetalleCompra()) ;
                sucursal = this.sucursalClients.findById(detalleCompra.getIdSucursal());
            } catch (FeignException ex) {
                throw new BoletaExeption("El cliente no existe en el sistema");
            }

            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setRunCliente(cliente.getIdCliente());
            clienteDTO.setNombreCompleto(cliente.getNombreCompleto());
            clienteDTO.setCorreo(cliente.getCorreo());

            DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO();
            detalleCompraDTO.setCosto(detalleCompra.getCosto());
            detalleCompraDTO.setCant(detalleCompra.getCant());
            detalleCompraDTO.setProducto(detalleCompra.getProducto());
            detalleCompraDTO.setFecha(detalleCompra.getFecha());
            detalleCompraDTO.setComentario(detalleCompra.getComentario());
            detalleCompraDTO.setIdSucursal(detalleCompra.getIdSucursal());

            BoletaDTO boletaDTO = new BoletaDTO();
            boletaDTO.setCliente(clienteDTO);
            boletaDTO.setDetalleCompra(detalleCompraDTO);
            return boletaDTO;

        }).toList();
    }

    @Override
    public Boleta findById(Long id) {
        return this.boletaRepositories.findById(id).orElseThrow(
                () -> new BoletaExeption("La sucursal con el id:" + id + "no existe")
        );
    }

    @Override
    public Boleta save(Boleta boleta) {
        return null;
    }
    }


