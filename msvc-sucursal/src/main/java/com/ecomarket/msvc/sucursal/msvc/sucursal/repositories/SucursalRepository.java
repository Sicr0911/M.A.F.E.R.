package com.ecomarket.msvc.sucursal.msvc.sucursal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

    List<Sucursal> findByIdSucursal(Long idSucursal);
}
