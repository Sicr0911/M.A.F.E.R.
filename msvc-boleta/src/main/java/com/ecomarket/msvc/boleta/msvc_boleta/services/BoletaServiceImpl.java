package com.ecomarket.msvc.boleta.msvc_boleta.services;

import com.ecomarket.msvc.boleta.msvc_boleta.exeptions.BoletaExeption;
import com.ecomarket.msvc.boleta.msvc_boleta.model.entities.Boleta;
import com.ecomarket.msvc.boleta.msvc_boleta.repositories.BoletaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletaServiceImpl implements BoletaService{

    @Autowired
    private BoletaRepositories boletaRepositories;

    @Override
    public List<Boleta> findAll() {
        return this.findAll();
    }

    @Override
    public Boleta findById(Long id) {
        return this.boletaRepositories.findById(id).orElseThrow(
                () -> new BoletaExeption("La sucursal con el id:" + id + "no existe")
        );
    }

    @Override
    public Boleta save(Boleta boleta) {
        return null;
    }

}
