package com.ecomarket.msvc.sucursal.msvc.sucursal.controller;

import com.ecomarket.msvc.sucursal.msvc.sucursal.assemblers.SucursalModelAssembler;
import com.ecomarket.msvc.sucursal.msvc.sucursal.dtos.ErrorDTO;
import com.ecomarket.msvc.sucursal.msvc.sucursal.model.Sucursal;
import com.ecomarket.msvc.sucursal.msvc.sucursal.service.SucursalService;
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
@RequestMapping("/api/v2/sucursales")
@Validated
@Tag(name = "Sucursales HATEOAS", description = "Esta sección contiene los CRUD de sucursal")
public class SucursalControllerV2 {

    @Autowired
    private SucursalService sucursalService;

    @Autowired
    private SucursalModelAssembler  sucursalModelAssembler;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(
            summary = "Devuelve todos los medicos",
            description = "Este metodo debe retornar un Lista de Susursal, en caso "+
                    "de que no encuentre nada retorna una Lista vacia"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se retornan todas las sucursales",
                    content = @Content(
                            mediaType = MediaTypes.HAL_JSON_VALUE,
                            schema = @Schema(implementation = Sucursal.class)
                    )
            )
    })

    public ResponseEntity<CollectionModel<EntityModel<Sucursal>>> findAll() {
        List<EntityModel<Sucursal>> entityModels = this.sucursalService.findAll()
                .stream()
                .map(sucursalModelAssembler::toModel)
                .toList();
        CollectionModel<EntityModel<Sucursal>> collectionModel = CollectionModel.of(
                entityModels,
                linkTo(methodOn(SucursalControllerV2.class).findAll()).withSelfRel()
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(collectionModel);
    }

    @GetMapping(value = "/{id}",  produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(
            summary = "Devuelve una sucursal segun su id",
            description = "Este metodo debe retornar un Medico cuando es consultado "+
                    "mediante su id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se retorna sucursal",
                    content = @Content(
                            mediaType = MediaTypes.HAL_JSON_VALUE,
                            schema = @Schema(implementation = Sucursal.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Error - sucursal con ID no existe",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDTO.class)
                    )
            )
    })
            @Parameters(value = {
                    @Parameter(name = "id", description = "Este es el id unico de una sucursal", required = true)
            })
    public ResponseEntity<EntityModel<Sucursal>> findById(@PathVariable Long id) {
        EntityModel<Sucursal> entityModel = this.sucursalModelAssembler.toModel(
                sucursalService.findById(id)
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(entityModel);
    }

}
