package com.ecomarket.msvc.inventario.msvc_inventario.assemblers;

import com.ecomarket.msvc.inventario.msvc_inventario.controllers.InventarioControllerV2;
import com.ecomarket.msvc.inventario.msvc_inventario.models.entities.Inventario;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

import org.springframework.hateoas.server.RepresentationModelAssembler;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@Component
public class InventarioModelAssembler implements RepresentationModelAssembler<Inventario, EntityModel<Inventario>> {


    @Override
    public EntityModel<Inventario> toModel(Inventario entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(InventarioControllerV2.class).findById(entity.getIdInventario())).withSelfRel(),
                linkTo(methodOn(InventarioControllerV2.class).findAll()).withRel("inventario"),
                Link.of("http://localhost:8005/productos/"+entity.getIdProducto()).withRel("producto"),
                Link.of("http://localhost:8006/productos/"+entity.getIdSucursal()).withRel("sucursal")
        );
    }
}
