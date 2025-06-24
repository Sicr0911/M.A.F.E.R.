package com.ecomarket.msvc.cliente.msvc_cliente.controllers;


import com.ecomarket.msvc.cliente.msvc_cliente.assemblers.ClienteModelAssembler;
import com.ecomarket.msvc.cliente.msvc_cliente.dtos.ErrorDTO;
import com.ecomarket.msvc.cliente.msvc_cliente.model.Cliente;
import com.ecomarket.msvc.cliente.msvc_cliente.services.ClienteService;
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
@RequestMapping("/api/v2/cliente")
@Validated
@Tag(name = "Clientes HATEOAS", description = "Esta sección contiene los CRUD de cliente")
public class ClienteControllerV2 {

        @Autowired
        private ClienteService clienteService;

        @Autowired
        private ClienteModelAssembler clienteModelAssembler;

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
                                schema = @Schema(implementation = Cliente.class)
                        )
                )
        })

        public ResponseEntity<CollectionModel<EntityModel<Cliente>>> findAll() {
            List<EntityModel<Cliente>> entityModels = this.clienteService.findAll()
                    .stream()
                    .map(clienteModelAssembler::toModel)
                    .toList();
            CollectionModel<EntityModel<Cliente>> collectionModel = CollectionModel.of(
                    entityModels,
                    linkTo(methodOn(ClienteControllerV2.class).findAll()).withSelfRel()
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
                                schema = @Schema(implementation = Cliente.class)
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
                @Parameter(name = "id", description = "Este es el id unico de un cliente", required = true)
        })
        public ResponseEntity<EntityModel<Cliente>> findById(@PathVariable Long id) {
            EntityModel<Cliente> entityModel = this.clienteModelAssembler.toModel(
                    clienteService.findById(id)
            );
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(entityModel);
        }
    }
