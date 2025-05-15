package com.ecomarket.msvc.boleta.msvc_boleta.boletarepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Boleta extends JpaRepository<, Long> {

    List<boletamodel> findByIdBoleta(Long, );
}
