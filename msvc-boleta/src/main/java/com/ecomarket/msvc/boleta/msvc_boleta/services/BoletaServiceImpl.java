package com.ecomarket.msvc.boleta.msvc_boleta.services;

import com.ecomarket.msvc.boleta.msvc_boleta.clients.ClienteClientsRest;
import com.ecomarket.msvc.boleta.msvc_boleta.clients.DetalleCompraClientsRest;
import com.ecomarket.msvc.boleta.msvc_boleta.clients.SucursalClientsRest;
import com.ecomarket.msvc.boleta.msvc_boleta.dtos.BoletaDTO;
import com.ecomarket.msvc.boleta.msvc_boleta.dtos.ClienteDTO;
import com.ecomarket.msvc.boleta.msvc_boleta.dtos.DetalleCompraDTO;
import com.ecomarket.msvc.boleta.msvc_boleta.dtos.SucursalDTO;
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
    private ClienteClientsRest clienteClientsRest;

    @Autowired
    private DetalleCompraClientsRest detalleCompraClientsRest;

    @Autowired
    private SucursalClientsRest sucursalClientsRest;

    @Override
    public List<BoletaDTO> findAll() {
        return this.boletaRepositories.findAll().stream().map(boleta  -> {

            Cliente cliente = null ;

            try {
                cliente = this.clienteClientsRest.findById(boleta.getIdCliente());
            } catch (FeignException ex) {
                throw new BoletaExeption("El cliente no existe en el sistema");
            }

            DetalleCompra detalleCompra = null ;
            Sucursal sucursal = null ;

            try {
                detalleCompra = this.detalleCompraClientsRest.findById(boleta.getIdDetalleCompra()) ;
                sucursal = this.sucursalClientsRest.findById(detalleCompra.getIdSucursal());
            } catch (FeignException ex) {
                throw new BoletaExeption("El detalle no existe en el sistema");
            }

            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setRunCliente(cliente.getRunCliente());
            clienteDTO.setNombreCompleto(cliente.getNombreCompleto());
            clienteDTO.setCorreo(cliente.getCorreo());

            DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO();
            detalleCompraDTO.setCosto(detalleCompra.getCosto());
            detalleCompraDTO.setCant(detalleCompra.getCant());
            detalleCompraDTO.setProducto(detalleCompra.getProducto());
            detalleCompraDTO.setFecha(detalleCompra.getFecha());
            detalleCompraDTO.setComentario(detalleCompra.getComentario());
            detalleCompraDTO.setIdSucursal(detalleCompra.getIdSucursal());

            SucursalDTO sucursalDTO = new SucursalDTO() ;
            sucursalDTO.setNombreSucursal(sucursal.getNombre());
            sucursalDTO.setDireccion(sucursal.getDireccion());
            sucursalDTO.setTelefono(sucursal.getTelefono());

            BoletaDTO boletaDTO = new BoletaDTO();
            boletaDTO.setCliente(clienteDTO);
            boletaDTO.setDetalleCompra(detalleCompraDTO);
            boletaDTO.setSucursal(sucursalDTO);

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
        try {
            Cliente cliente = this.clienteClientsRest.findById(boleta.getIdCliente());
            DetalleCompra detalleCompra = this.detalleCompraClientsRest.findById(boleta.getIdDetalleCompra());
        } catch (FeignException ex) {
            throw new BoletaExeption("El cliente no está asociado en el sistema");
        }
        return this.boletaRepositories.save(boleta);
    }

    @Override
    public List<Boleta> findBySucursalId(Long sucursalId) {
        return this.boletaRepositories.findByIdSucursal(sucursalId);
    }

    @Override
    public List<Boleta> findByClienteId(Long clienteId) {
        return this.boletaRepositories.findByIdCliente(clienteId);
    }

    @Override
    public List<Boleta> findByDetalleCompraId(Long detalleCompraId) {
        return this.boletaRepositories.findByIdDetalleCompra(detalleCompraId);
    }

}


