package com.ecomarket.msvc.boleta.msvc_boleta.controller;

import com.ecomarket.msvc.boleta.msvc_boleta.services.BoletaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Validated
@Tag(name = "Boletas HATEOAS", description = "Esta seccion contiene los CRUD de boleta")
public class BoletaControllerV2 {

    @Autowired
    private BoletaService boletaService;

    @Autowired

}
