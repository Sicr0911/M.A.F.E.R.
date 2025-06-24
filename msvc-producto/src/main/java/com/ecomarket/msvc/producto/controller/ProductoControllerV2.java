package com.ecomarket.msvc.producto.controller;

import com.ecomarket.msvc.producto.assemblers.ProductoModelAssembler;
import com.ecomarket.msvc.producto.dtos.ErrorDTO;
import com.ecomarket.msvc.producto.models.Producto;
import com.ecomarket.msvc.producto.service.ProductoService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v2/productos")
@Validated
@Tag(name = "Productos HATEOAS", description = "Esta sección contiene los CRUD de producto")
public class ProductoControllerV2 {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoModelAssembler productoModelAssembler;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(
            summary = "Devuelve todos los productos",
            description = "Este metodo debe retornar un List de Producto, en caso " +
                    "de que no encuentre nada retorna una List vacia"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se retornaron todos los Productos ok",
                    content = @Content(
                            mediaType = MediaTypes.HAL_JSON_VALUE,
                            schema = @Schema(implementation = Producto.class)
                    )
            )
    })

    public ResponseEntity<CollectionModel<EntityModel<Producto>>> findAll() {
        List<EntityModel<Producto>> entityModels = this.productoService.findAll()
                .stream()
                .map(productoModelAssembler::toModel)
                .toList();
        CollectionModel<EntityModel<Producto>> collectionModel = CollectionModel.of(
                entityModels,
                linkTo(methodOn(ProductoControllerV2.class).findAll()).withSelfRel()
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(collectionModel);
    }

    @GetMapping(value = "/{id}",  produces = MediaTypes.HAL_JSON_VALUE)
        @Operation(
                summary = "Devuelve un Producto con respecto a su id",
                description = "Este metodo debe retornar un Producto cuando es consultado "+
                        "mediante su id"
        )
        @ApiResponses(value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Se retorna el Producto encontrado",
                        content = @Content(
                                mediaType = MediaTypes.HAL_JSON_VALUE,
                                schema = @Schema(implementation = Producto.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Error - Producto con ID no existe",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ErrorDTO.class)
                        )
                )
        })
        @Parameters(value = {
                @Parameter(name = "id", description = "Este es el id unico de un Producto", required = true)
        })
        public ResponseEntity<EntityModel<Producto>> findById(@PathVariable Long id) {
            EntityModel<Producto> entityModel = this.productoModelAssembler.toModel(
                    productoService.findById(id)
            );
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(entityModel);
        }

}
