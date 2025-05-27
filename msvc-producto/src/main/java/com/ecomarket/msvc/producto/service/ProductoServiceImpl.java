package com.ecomarket.msvc.producto.service;

import com.ecomarket.msvc.producto.exceptions.ProductoException;
import com.ecomarket.msvc.producto.models.Producto;
import com.ecomarket.msvc.producto.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return this.productoRepository.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return this.productoRepository.findById(id).orElseThrow(
                () -> new ProductoException("Producto con Id " +id+ " no encontrado"));
    }

    @Override
    public Producto save(Producto producto) {
        if(this.productoRepository.findByNombre(producto.getNombre()).isPresent()){
            throw new ProductoException("Producto ya existente");
        }
        return this.productoRepository.save(producto);
    }

}
