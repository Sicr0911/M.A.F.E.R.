package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.repositories;

import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.entities.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Long> {

    List<DetalleCompra> findByIdBoleta(Long idBoleta);

    List<DetalleCompra> findByIdProducto(Long idProducto);
}
