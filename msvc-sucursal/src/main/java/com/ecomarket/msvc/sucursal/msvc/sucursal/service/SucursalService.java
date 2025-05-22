package com.ecomarket.msvc.sucursal.msvc.sucursal.service;

import com.ecomarket.msvc.sucursal.msvc.sucursal.model.Sucursal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SucursalService {

    List<Sucursal> findAll();
    Sucursal findById(Long id);
    Sucursal save(Sucursal sucursal);

}
