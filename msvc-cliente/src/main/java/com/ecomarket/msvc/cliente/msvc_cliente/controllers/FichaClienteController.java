package com.ecomarket.msvc.cliente.msvc_cliente.controllers;

import com.ecomarket.msvc.cliente.msvc_cliente.dtos.FichaClienteDTO;
import com.ecomarket.msvc.cliente.msvc_cliente.model.entities.FichaCliente;
import com.ecomarket.msvc.cliente.msvc_cliente.services.FichaClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Validated
public class FichaClienteController {

    @Autowired
    private FichaClienteService fichaClienteService;

    @GetMapping
    public ResponseEntity<List<FichaCliente>> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.fichaClienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FichaCliente> findById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.fichaClienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<FichaCliente> save(@Valid @RequestBody FichaClienteDTO fichaCliente){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.fichaClienteService.save(fichaCliente));
    }
}
