package com.ecomarket.msvc.inventario.msvc_inventario.controllers;

import com.ecomarket.msvc.inventario.msvc_inventario.assemblers.InventarioModelAssembler;
import com.ecomarket.msvc.inventario.msvc_inventario.dtos.ErrorDTO;
import com.ecomarket.msvc.inventario.msvc_inventario.models.entities.Inventario;
import com.ecomarket.msvc.inventario.msvc_inventario.services.InventarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v2/inventario")
@Validated
@Tag(name = "Inventario HATEOAS", description = "Esta sección contiene los CRUD de inventario")
public class InventarioControllerV2 {

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private InventarioModelAssembler inventarioModelAssembler;

    @Autowired InventarioControllerV2 inventarioControllerV2;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(
            summary = "Devuelve el inventario",
            description = "Este metodo debe retornar un Lista de inventario, en caso "+
                    "de que no encuentre nada retorna una Lista vacia"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se retornara el inventario",
                    content = @Content(
                            mediaType = MediaTypes.HAL_JSON_VALUE,
                            schema = @Schema(implementation = Inventario.class)
                    )
            )
    })
    public ResponseEntity<CollectionModel<EntityModel<Inventario>>> findAll() {
        List<EntityModel<Inventario>> entityModels = this.inventarioService.findAll()
                .stream()
                .map(inventarioModelAssembler::toModel)
                .toList();
        CollectionModel<EntityModel<Inventario>> collectionModel = CollectionModel.of(
                entityModels,
                linkTo(methodOn(InventarioControllerV2.class).findAll()).withSelfRel()
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(collectionModel);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se retorna el inventario encontrado",
                    content = @Content(
                            mediaType = MediaTypes.HAL_JSON_VALUE,
                            schema = @Schema(implementation = Inventario.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Error - Medico con ID no existe",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDTO.class)
                    )
            )
    })

    @Parameters(value = {
            @Parameter(name = "id", description = "Este es el id unico de inventario", required = true)
    })
    public ResponseEntity<EntityModel<Inventario>> findById(@PathVariable Long id) {
        EntityModel<Inventario> entityModel = this.inventarioModelAssembler.toModel(
                inventarioService.findById(id)
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(entityModel);
}
