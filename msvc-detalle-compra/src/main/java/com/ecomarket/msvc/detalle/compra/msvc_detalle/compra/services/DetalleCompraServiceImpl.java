package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.services;


import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.clients.BoletaClientsRest;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos.BoletaDTO;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos.DetalleCompraDTO;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos.ProductoDTO;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.Boleta;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.exceptions.DetalleCompraException;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.entities.DetalleCompra;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.repositories.DetalleCompraRepository;
import com.ecomarket.msvc.inventario.msvc_inventario.clients.ProductoClientsRest;
import com.ecomarket.msvc.inventario.msvc_inventario.models.Producto;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DetalleCompraServiceImpl implements DetalleCompraServices{

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Autowired
    private BoletaClientsRest boletaClientsRest;

    @Autowired
    private ProductoClientsRest productoClientsRest;

    @Override
    public List<DetalleCompraDTO> findAll() {
        return this.detalleCompraRepository.findAll().stream().map(detalleCompra -> {

            Boleta boleta = null;
            try {
                boleta = this.boletaClientsRest.findById(detalleCompra.getIdBoleta());
            } catch (FeignException ex) {
                throw new DetalleCompraException("La boleta no existe");
            }

            Producto producto = null;
            try {
                producto = this.productoClientsRest.findById(detalleCompra.getIdBoleta());
            } catch (FeignException ex) {
                throw new DetalleCompraException("El producto no existe");
            }

            BoletaDTO boletaDTO = new BoletaDTO() ;
            boletaDTO.setHoraBoleta(boleta.getHoraBoleta());
            boletaDTO.setCosto(boletaDTO.getCosto());
            boletaDTO.setDetalle(boletaDTO.getDetalle());

            ProductoDTO productoDTO = new ProductoDTO() ;
            productoDTO.setNombreProducto(producto.getNombreProducto());
            productoDTO.setDescripcionProducto(producto.getDescripcionProducto());
            productoDTO.setPrecioProducto(producto.getPrecioProducto());

            DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO() ;
            detalleCompraDTO.setIdBoleta(boletaDTO) ;
            detalleCompraDTO.setIdProducto(productoDTO);

            return detalleCompraDTO ;


        }).toList() ;

    }

    @Override
    public DetalleCompra findbyId(Long id) {
        return this.detalleCompraRepository.findById(id).orElseThrow(
            () -> new DetalleCompraException("El detalle con el id:" + id + "no existe")
        );
    }

    @Override
    public DetalleCompra save(DetalleCompra detalleCompra) {
        return null;
    }

}
