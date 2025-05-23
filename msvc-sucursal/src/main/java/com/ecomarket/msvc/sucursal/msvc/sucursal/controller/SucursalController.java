package com.ecomarket.msvc.sucursal.msvc.sucursal.controller;

import com.ecomarket.msvc.sucursal.msvc.sucursal.model.Sucursal;
import com.ecomarket.msvc.sucursal.msvc.sucursal.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sucursales")
@Validated

public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<Sucursal>> findAll() {
        List<Sucursal> sucursales = this.sucursalService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(sucursales);
    }

}
