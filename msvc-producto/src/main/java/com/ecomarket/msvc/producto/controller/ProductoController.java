package com.ecomarket.msvc.producto.controller;

import com.ecomarket.msvc.producto.models.entities.Producto;
import com.ecomarket.msvc.producto.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
@Validated

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> findAll() {
        List<Producto> productos = this.productoService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productos);
    }

    @PostMapping
    public ResponseEntity<Producto> save(@Valid @RequestBody Producto boleta) {
        Producto saved = this.productoService.save(boleta);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(saved);
    }

}
