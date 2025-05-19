package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@Validated
public class DetalleCompra {

    @Autowired
    private DetalleCompra detalleCompra;
}
