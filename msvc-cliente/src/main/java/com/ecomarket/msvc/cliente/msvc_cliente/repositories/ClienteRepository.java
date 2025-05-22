package com.ecomarket.msvc.cliente.msvc_cliente.repositories;

import com.ecomarket.msvc.cliente.msvc_cliente.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findById(Long idCliente);
}
