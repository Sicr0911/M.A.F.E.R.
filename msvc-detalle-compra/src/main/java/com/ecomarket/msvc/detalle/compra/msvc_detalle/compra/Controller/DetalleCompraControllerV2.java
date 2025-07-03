package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.Controller;

import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.assemblers.DetalleCompraDTOModelAssembler;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.assemblers.DetalleCompraModelassembler;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos.DetalleCompraDTO;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos.ErrorDTO;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.entities.DetalleCompra;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.services.DetalleCompraServices;
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
@RequestMapping("/api/v2/detalle-compra")
@Validated
@Tag(name = "Detalle Compra HATEOAS", description = "Esta sección contiene los CRUD de detalle-compra")
public class DetalleCompraControllerV2 {


    @Autowired
    private DetalleCompraServices detalleCompraServices;

    @Autowired
    private DetalleCompraModelassembler detalleCompraModelassembler;

    @Autowired
    private DetalleCompraDTOModelAssembler detalleCompraDTOModelAssembler;


    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(
            summary = "Devuelve todos los clientes",
            description = "Este metodo debe retornar un List de Cliente, en caso "+
                    "de que no encuentre nada retorna una List vacia"
        )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se retornaron todos los clientes ok",
                    content = @Content(
                            mediaType = MediaTypes.HAL_JSON_VALUE,
                            schema = @Schema(implementation = DetalleCompra.class)
                        )
                )
        })

        public ResponseEntity<CollectionModel<EntityModel<DetalleCompraDTO>>> findAll() {
            List<EntityModel<DetalleCompraDTO>> entityModels = this.detalleCompraServices.findAll()
                    .stream()
                    .map(detalleCompraDTOModelAssembler::toModel)
                    .toList();
            CollectionModel<EntityModel<DetalleCompraDTO>> collectionModel = CollectionModel.of(
                    entityModels,
                    linkTo(methodOn(DetalleCompraControllerV2.class).findAll()).withSelfRel()
            );
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(collectionModel);
        }

        @GetMapping(value = "/{id}",  produces = MediaTypes.HAL_JSON_VALUE)
        @Operation(
                summary = "Devuelve un cliente con respecto a su id",
                description = "Este metodo debe retornar un Cliente cuando es consultado "+
                        "mediante su id"
        )
        @ApiResponses(value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Se retorna el cliente encontrado",
                        content = @Content(
                                mediaType = MediaTypes.HAL_JSON_VALUE,
                                schema = @Schema(implementation = DetalleCompra.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Error - cliente con ID no existe",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ErrorDTO.class)
                        )
                )
        })
        @Parameters(value = {
                @Parameter(name = "id", description = "Este es el id unico de un detalle", required = true)
        })
        public ResponseEntity<EntityModel<DetalleCompra>> findById(@PathVariable Long id) {
            EntityModel<DetalleCompra> entityModel = this.detalleCompraModelassembler.toModel(
                    detalleCompraServices.findById(id)
            );
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(entityModel);
        }

    @GetMapping(value = "/{id}/boletas", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(
            summary = "Devuelve todos los detalles de una boleta con respecto a su id",
            description = "Este metodo debe retornar las detalles de la bolera cuando es consultado "+
                    "mediante su id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se retorna el detalle encontrado",
                    content = @Content(
                            mediaType = MediaTypes.HAL_JSON_VALUE,
                            schema = @Schema(implementation = DetalleCompraDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Error - boleta con ID no existe",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDTO.class)
                    )
            )
    })
    @Parameters(value = {
            @Parameter(name = "id", description = "Este es el id unico de una boleta", required = true)
    })
    public ResponseEntity<CollectionModel<EntityModel<DetalleCompra>>> findByBoletaId(@PathVariable Long id) {
        List<EntityModel<DetalleCompra>> entityModels = this.detalleCompraServices.findByBoletaId(id)
                .stream()
                .map(detalleCompraModelassembler::toModel)
                .toList();

        CollectionModel<EntityModel<DetalleCompra>> collectionModel = CollectionModel.of(
                entityModels,
                linkTo(methodOn(DetalleCompraControllerV2.class).findByBoletaId(id)).withSelfRel()
        );
        return ResponseEntity.status(HttpStatus.OK).body(collectionModel);
    }

}
