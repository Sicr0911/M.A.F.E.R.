package com.ecomarket.msvc.inventario.msvc_inventario.services;

import com.ecomarket.msvc.inventario.msvc_inventario.clients.ProductoClientsRest;
import com.ecomarket.msvc.inventario.msvc_inventario.clients.SucursalClientsRest;
import com.ecomarket.msvc.inventario.msvc_inventario.dtos.InventarioDTO;
import com.ecomarket.msvc.inventario.msvc_inventario.dtos.ProductoDTO;
import com.ecomarket.msvc.inventario.msvc_inventario.dtos.SucursalDTO;
import com.ecomarket.msvc.inventario.msvc_inventario.exceptions.InventarioException;
import com.ecomarket.msvc.inventario.msvc_inventario.models.Inventario;
import com.ecomarket.msvc.inventario.msvc_inventario.models.Producto;
import com.ecomarket.msvc.inventario.msvc_inventario.models.Sucursal;
import com.ecomarket.msvc.inventario.msvc_inventario.repositories.InventarioRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private ProductoClientsRest productoClientsRest ;

    @Autowired
    private SucursalClientsRest sucursalClientsRest ;

    @Override
    public List<InventarioDTO> findAll() {
        return this.inventarioRepository.findAll().stream().map(inventario -> {

            Producto producto = null ;

            try {
                producto = this.productoClientsRest.findById(inventario.getIdProducto()) ;
            } catch (FeignException ex) {
                throw new InventarioException("El producto no existe en la base de datos.") ;
            }

            Sucursal sucursal = null ;

            try {
                sucursal = this.sucursalClientsRest.findById(inventario.getIdSucursal()) ;
            } catch (FeignException ex) {
                throw new InventarioException("Sucursal no encontrada") ;
            }

            ProductoDTO productoDTO = new ProductoDTO() ;
            productoDTO.setNombreProducto(producto.getNombreProducto());
            productoDTO.setDescripcionProducto(producto.getDescripcionProducto()) ;
            productoDTO.setPrecioProducto(producto.getPrecioProducto());

            SucursalDTO sucursalDTO = new SucursalDTO() ;
            sucursalDTO.setNombre(sucursal.getNombre());
            sucursalDTO.setDireccion(sucursal.getDireccion());
            sucursalDTO.setTelefono(sucursal.getTelefono());

            InventarioDTO inventarioDTO = new InventarioDTO() ;
            inventarioDTO.setIdProducto(productoDTO);
            inventarioDTO.setIdSucursal(sucursalDTO);

            return inventarioDTO ;

        }).toList() ;
    }

    @Override
    public Inventario findById(Long id) {
        return this.inventarioRepository.findById(id).orElseThrow(
                () -> new InventarioException("El usuario con el id " + id + "no fue encontrado")
        );
    }

    @Override
    public Inventario save(Inventario inventario) {
        try {
            Producto producto = this.productoClientsRest.findById(inventario.getIdProducto()) ;
            Sucursal sucursal = this.sucursalClientsRest.findById(inventario.getIdSucursal()) ;
        } catch (FeignException ex) {
            throw new InventarioException("Existen problemas con la asoción") ;
        }
        return this.inventarioRepository.save(inventario) ;
    }

    @Override
    public void deleteById(Long id) {
        inventarioRepository.deleteById(id);
    }

    @Override
    public List<Inventario> findByProductoId(Long productoId) {
        return this.inventarioRepository.findByIdProducto(productoId);
    }

    @Override
    public List<Inventario> findBySucursalId(Long sucursalId) {
        return this.inventarioRepository.findByIdSucursal(sucursalId);
    }

}