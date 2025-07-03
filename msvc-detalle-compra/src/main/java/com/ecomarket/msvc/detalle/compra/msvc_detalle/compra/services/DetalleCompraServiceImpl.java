package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.services;

import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.clients.BoletaClientsRest;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.clients.ProductoClientsRest;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos.BoletaDTO;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos.DetalleCompraDTO;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos.ProductoDTO;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.Boleta;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.exceptions.DetalleCompraException;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.entities.DetalleCompra;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.repositories.DetalleCompraRepository;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.Producto;
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
                producto = this.productoClientsRest.findById(detalleCompra.getIdProducto());
            } catch (FeignException ex) {
                throw new DetalleCompraException("El producto no existe");
            }

            BoletaDTO boletaDTO = new BoletaDTO() ;
            boletaDTO.setId(detalleCompra.getIdBoleta());
            boletaDTO.setHoraBoleta(boleta.getHoraBoleta());
            boletaDTO.setDetalle(boleta.getDetalle());

            ProductoDTO productoDTO = new ProductoDTO() ;
            productoDTO.setNombreProducto(producto.getNombreProducto());
            productoDTO.setDescripcionProducto(producto.getDescripcionProducto());
            productoDTO.setPrecioProducto(producto.getPrecioProducto());

            DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO();
            detalleCompraDTO.setId(detalleCompra.getIdDetalleCompra());
            detalleCompraDTO.setIdBoleta(boletaDTO) ;
            detalleCompraDTO.setIdProducto(productoDTO);

            return detalleCompraDTO ;

        }).toList() ;
    }

    @Override
    public DetalleCompra findById(Long id) {
        return this.detalleCompraRepository.findById(id).orElseThrow(
            () -> new DetalleCompraException("El detalle con el id:" + id + "no existe")
        );
    }

    @Override
    public DetalleCompra save(DetalleCompra detalleCompra) {
        try {
            Boleta boleta = this.boletaClientsRest.findById(detalleCompra.getIdBoleta());
            Producto producto = this.productoClientsRest.findById(detalleCompra.getIdProducto());
        } catch (FeignException ex) {
            throw new DetalleCompraException("El cliente no está asociado en el sistema");
        }
        return this.detalleCompraRepository.save(detalleCompra);
    }

    @Override
    public List<DetalleCompra> findByProductoId(Long productoId) {
        return this.detalleCompraRepository.findByIdProducto(productoId);
    }

    @Override
    public List<DetalleCompra> findByBoletaId(Long boletaId) {
        return this.detalleCompraRepository.findByIdBoleta(boletaId);
    }

}
