package com.ecomarket.msvc.sucursal.msvc.sucursal.service;

import com.ecomarket.msvc.sucursal.msvc.sucursal.exceptions.SucursalException;
import com.ecomarket.msvc.sucursal.msvc.sucursal.model.entities.Sucursal;
import com.ecomarket.msvc.sucursal.msvc.sucursal.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<Sucursal> findAll() {
        return this.sucursalRepository.findAll();
    }

    @Override
    public Sucursal findById(Long id) {
        return sucursalRepository.findById(id).orElseThrow(
                () -> new SucursalException("la sucursal "+id +" no existe")
        );
    }

    @Override
    public Sucursal save(Sucursal sucursal) {return sucursalRepository.save(sucursal);}
}