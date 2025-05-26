package com.ecomarket.msvc.inventario.msvc_inventario.services;

import com.ecomarket.msvc.inventario.msvc_inventario.dtos.InventarioDTO;
import com.ecomarket.msvc.inventario.msvc_inventario.models.Inventario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventarioService {

    List<InventarioDTO> findAll();
    Inventario findById(Long id) ;
    Inventario save(Inventario inventario);
    void deleteById (Long id) ;

}
