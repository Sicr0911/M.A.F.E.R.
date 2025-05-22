package com.ecomarket.msvc.cliente.msvc_cliente.controllers;

import com.ecomarket.msvc.cliente.msvc_cliente.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
@Validated
public class ClienteController {

    @Autowired
    private ClienteService clienteService ;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAl() {
        List<Cliente> clientes = this.clienteService.findAll() ;
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clientes) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        Cliente cliente = this.clienteService.findById(id) ;
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cliente) ;
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@Valid @RequestBody Cliente cliente) {
        Cliente saved = this.clienteService.save(cliente) ;
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved) ;
    }

}

