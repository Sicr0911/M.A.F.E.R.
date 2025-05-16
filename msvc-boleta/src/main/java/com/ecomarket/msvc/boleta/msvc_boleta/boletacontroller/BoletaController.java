package com.ecomarket.msvc.boleta.msvc_boleta.boletacontroller;

import com.ecomarket.msvc.boleta.msvc_boleta.boletaservices.Boleta;
import com.ecomarket.msvc.boleta.msvc_boleta.boletaservices.BoletaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class BoletaController {

    @Autowired
    private BoletaService boletaService ;

    @GetMapping("/{id}")
    public ResponseEntity<List<Boleta>> findAll()  {
        List<Boleta> boletas = boletaService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(boletas);
    }

    @PostMapping
    public ResponseEntity<Boleta> save(@Valid @RequestBody Boleta boleta) {
        Boleta saved = this.boletaService.save(boleta);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(saved);
    }
}
