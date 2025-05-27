package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.Controller;

import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos.DetalleCompraDTO;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.DetalleCompra;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.services.DetalleCompraServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@Validated
public class DetalleCompraController {

    @Autowired
    private DetalleCompraServices detalleCompraServices;

    @GetMapping
    public ResponseEntity<List<DetalleCompraDTO>> findAll() {
        List<DetalleCompraDTO> detalles = this.detalleCompraServices.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(detalles);
    }
}
