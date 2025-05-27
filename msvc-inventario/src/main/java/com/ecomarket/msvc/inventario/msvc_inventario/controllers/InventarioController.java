package com.ecomarket.msvc.inventario.msvc_inventario.controllers;

import com.ecomarket.msvc.inventario.msvc_inventario.dtos.InventarioDTO;
import com.ecomarket.msvc.inventario.msvc_inventario.models.Inventario;
import com.ecomarket.msvc.inventario.msvc_inventario.services.InventarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/inventarios")
@Validated

public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public ResponseEntity<List<InventarioDTO>> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.inventarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> findById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.inventarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Inventario> save(@RequestBody @Valid Inventario inventario) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.inventarioService.save(inventario));
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<List<Inventario>> findByIdProducto(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.inventarioService.findByProductoId(id));
    }

    @GetMapping("/sucursal/{id}")
    public ResponseEntity<List<Inventario>> findByIdSucursal(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.inventarioService.findBySucursalId(id));
    }
}