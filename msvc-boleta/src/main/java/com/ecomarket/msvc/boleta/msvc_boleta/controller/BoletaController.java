package com.ecomarket.msvc.boleta.msvc_boleta.controller;

import com.ecomarket.msvc.boleta.msvc_boleta.dtos.BoletaDTO;
import com.ecomarket.msvc.boleta.msvc_boleta.model.entities.Boleta;
import com.ecomarket.msvc.boleta.msvc_boleta.services.BoletaService;
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
public class BoletaController {

    @Autowired
    private BoletaService boletaService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Boleta>> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.boletaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Boleta> save(@Valid @RequestBody Boleta boleta) {
        Boleta saved = this.boletaService.save(boleta);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(saved);
    }
}


