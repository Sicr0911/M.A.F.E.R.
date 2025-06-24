package com.ecomarket.msvc.sucursal.msvc.sucursal.assemblers;

import com.ecomarket.msvc.sucursal.msvc.sucursal.controller.SucursalControllerV2;
import com.ecomarket.msvc.sucursal.msvc.sucursal.model.Sucursal;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SucursalModelAssembler implements RepresentationModelAssembler<Sucursal, EntityModel<Sucursal>> {
    @Override
    public EntityModel<Sucursal> toModel(Sucursal entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(SucursalControllerV2.class).findById(entity.getIdSucursal())).withSelfRel(),
                linkTo(methodOn(SucursalControllerV2.class).findAll()).withRel("sucursal"),
                Link.of("http://localhost:8006/sucursal/"+entity.getIdSucursal()).withRel("sucursal")
        );
    }
}
