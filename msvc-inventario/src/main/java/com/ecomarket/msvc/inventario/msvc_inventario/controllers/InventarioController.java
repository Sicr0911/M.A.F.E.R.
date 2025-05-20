package com.ecomarket.msvc.inventario.msvc_inventario.controllers;

import com.ecomarket.msvc.inventario.msvc_inventario.models.Inventario;
import com.ecomarket.msvc.inventario.msvc_inventario.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/inventarios")
@Validated

public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public ResponseEntity<List<Inventario>> findAll(){
        List<Inventario> inventarios = this.inventarioService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(inventarios);
    }

}
