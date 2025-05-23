package com.ecomarket.msvc.producto.controller;

import com.ecomarket.msvc.producto.models.entities.Producto;
import com.ecomarket.msvc.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventarios")
@Validated

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> findAll() {
        List<Producto> sucursales = this.productoService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(sucursales);
    }

}
