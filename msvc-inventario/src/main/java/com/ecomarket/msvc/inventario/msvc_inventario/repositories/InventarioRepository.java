package com.ecomarket.msvc.inventario.msvc_inventario.repositories;

import com.ecomarket.msvc.inventario.msvc_inventario.models.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventarioRepository extends JpaRepository <Inventario,Long> {

    List<Inventario> findByIdProducto(Long idProductos);

    List<Inventario> findByIdSucursal(Long idSucursales);
}
