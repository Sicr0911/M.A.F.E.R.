package com.ecomarket.msvc.inventario.msvc_inventario.inventarioservice;

import com.ecomarket.msvc.inventario.msvc_inventario.exceptions.InventarioException;
import com.ecomarket.msvc.inventario.msvc_inventario.inventariomodel.Inventario;
import com.ecomarket.msvc.inventario.msvc_inventario.inventariorepository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public List<Inventario> findAll() {
        return this.findAll();
    }

    @Override
    public Inventario findById(Long id) {
        return this.inventarioRepository.findById(id).orElseThrow(
                () -> new InventarioException("El usuario con el id " + id + "no fue encontrado")
        )
    }

    @Override
    public Inventario save(Inventario inventario) {
        return null;
    }
}
