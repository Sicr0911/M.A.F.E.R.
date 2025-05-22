package com.ecomarket.msvc.boleta.msvc_boleta.repositories;

import com.ecomarket.msvc.boleta.msvc_boleta.services.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoletaRepositories extends JpaRepository<Boleta, Long> {

    List<Boleta> findIdBoleta(Long IdDetalleCompra);

    List<Cliente> findIdCliente(Long IdCliente);
}
