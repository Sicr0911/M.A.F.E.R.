package com.ecomarket.msvc.cliente.msvc_cliente.clienterepository;

import com.ecomarket.msvc.cliente.msvc_cliente.clientemodel.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
