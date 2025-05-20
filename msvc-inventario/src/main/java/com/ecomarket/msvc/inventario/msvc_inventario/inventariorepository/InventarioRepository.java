package com.ecomarket.msvc.inventario.msvc_inventario.inventariorepository;

import com.ecomarket.msvc.inventario.msvc_inventario.models.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository <Inventario,Long> {
}
