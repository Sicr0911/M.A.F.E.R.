package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.Controller;

import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos.DetalleCompraDTO;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.entities.DetalleCompra;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.services.DetalleCompraServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/detalle-compra")
@Validated
public class DetalleCompraController {

    @Autowired
    private DetalleCompraServices detalleCompraServices;

    @GetMapping("/{id}")
    public ResponseEntity<List<DetalleCompraDTO>> findAll() {
        List<DetalleCompraDTO> detalles = this.detalleCompraServices.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(detalles);
    }

    @PostMapping
    public ResponseEntity<DetalleCompra> save(@Valid @RequestBody DetalleCompra detalleCompra) {
        DetalleCompra saved = this.detalleCompraServices.save(detalleCompra);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(saved);
    }

}
