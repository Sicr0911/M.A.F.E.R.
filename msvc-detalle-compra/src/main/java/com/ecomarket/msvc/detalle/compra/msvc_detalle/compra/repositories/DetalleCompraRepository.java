package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.repositories;

import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Long> {

    List<DetalleCompra> findByIdBoleta(Long idBoleta);
}
