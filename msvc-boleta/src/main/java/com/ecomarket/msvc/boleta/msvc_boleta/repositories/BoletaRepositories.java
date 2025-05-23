package com.ecomarket.msvc.boleta.msvc_boleta.repositories;

import com.ecomarket.msvc.boleta.msvc_boleta.model.entities.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoletaRepositories extends JpaRepository<Boleta, Long> {

    List<Boleta> findByIdDetalleCompra(Long idDetalleCompra);

    List<Boleta> findByIdSucursal(Long idSucursal);
}
