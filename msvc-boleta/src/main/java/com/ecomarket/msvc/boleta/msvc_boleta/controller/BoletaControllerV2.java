package com.ecomarket.msvc.boleta.msvc_boleta.controller;

import com.ecomarket.msvc.boleta.msvc_boleta.assemblers.BoletaDTOModelAssembler;
import com.ecomarket.msvc.boleta.msvc_boleta.assemblers.BoletaModelAssembler;
import com.ecomarket.msvc.boleta.msvc_boleta.dtos.BoletaDTO;
import com.ecomarket.msvc.boleta.msvc_boleta.dtos.errorDTO;
import com.ecomarket.msvc.boleta.msvc_boleta.model.entities.Boleta;
import com.ecomarket.msvc.boleta.msvc_boleta.services.BoletaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/api/v2/boletas")
@Validated
@Tag(name = "Boletas HATEOAS", description = "Esta sección contiene los CRUD de boleta")
public class BoletaControllerV2 {

    @Autowired
    private BoletaService boletaService;

    @Autowired
    private BoletaModelAssembler boletaModelAssembler;

    @Autowired
    private BoletaDTOModelAssembler boletaDTOModelAssembler;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(
            summary = "Devuelve todos los medicos",
            description = "Este metodo debe retornar un List de Medico, en caso "+
                    "de que no encuentre nada retorna una List vacia"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se retornaron todos los medicos ok",
                    content = @Content(
                            mediaType = MediaTypes.HAL_JSON_VALUE,
                            schema = @Schema(implementation = Boleta.class)
                    )
            )
    })
    public ResponseEntity<CollectionModel<EntityModel<BoletaDTO>>> findAll() {
        List<EntityModel<BoletaDTO>> entityModels = this.boletaService.findAll()
                .stream()
                .map(boletaDTOModelAssembler::toModel)
                .toList();
        CollectionModel<EntityModel<BoletaDTO>> collectionModel = CollectionModel.of(
                entityModels,
                linkTo(methodOn(BoletaControllerV2.class).findAll()).withSelfRel()
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(collectionModel);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se retorna el medico encontrado",
                    content = @Content(
                            mediaType = MediaTypes.HAL_JSON_VALUE,
                            schema = @Schema(implementation = Boleta.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Error - Medico con ID no existe",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = errorDTO.class)
                    )
            )
    })

    @Parameters(value = {
            @Parameter(name = "id", description = "Este es el id unico de una sucursal", required = true)
    })
    public ResponseEntity<EntityModel<Boleta>> findById(@PathVariable Long id) {
        EntityModel<Boleta> entityModel = this.boletaModelAssembler.toModel(
                boletaService.findById(id)
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(entityModel);

    }
}
