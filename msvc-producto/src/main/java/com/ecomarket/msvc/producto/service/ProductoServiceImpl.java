package com.ecomarket.msvc.producto.service;

import com.ecomarket.msvc.producto.exceptions.ProductoException;
import com.ecomarket.msvc.producto.models.entities.Producto;
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
        return this.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return this.productoRepository.findById(id).orElseThrow(
                () -> new ProductoException("La sucursal con el id:" + id + "no existe")
        );
    }

    @Override
    public Producto save(Producto producto) {
        return null;
    }

}
