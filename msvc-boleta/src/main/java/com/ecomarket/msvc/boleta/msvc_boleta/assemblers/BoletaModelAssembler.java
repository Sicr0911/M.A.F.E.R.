package com.ecomarket.msvc.boleta.msvc_boleta.assemblers;

import com.ecomarket.msvc.boleta.msvc_boleta.controller.BoletaControllerV2;
import com.ecomarket.msvc.boleta.msvc_boleta.model.entities.Boleta;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BoletaModelAssembler implements RepresentationModelAssembler<Boleta, EntityModel<Boleta>> {

    @Override
    public EntityModel<Boleta> toModel(Boleta entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(BoletaControllerV2.class).findById(entity.getIdBoleta())).withSelfRel(),
                linkTo(methodOn(BoletaControllerV2.class).findAll()).withRel("Boletas"),
                Link.of("http://localhost:8001/boleta/" + entity.getIdBoleta()).withRel("boletas")
        );
    }
}