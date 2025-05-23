package com.ecomarket.msvc.boleta.msvc_boleta.repositories;

import com.ecomarket.msvc.boleta.msvc_boleta.model.entities.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoletaRepositories extends JpaRepository<Boleta, Long> {

    List<Boleta> findByIdDetalleCompra(Long idDetalleCompra);

    List<Boleta> findByIdSucursal(Long idSucursal);
}
