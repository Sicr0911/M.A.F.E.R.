package com.ecomarket.msvc.boleta.msvc_boleta.assemblers;

import com.ecomarket.msvc.boleta.msvc_boleta.controller.BoletaControllerV2;
import com.ecomarket.msvc.boleta.msvc_boleta.dtos.BoletaDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BoletaDTOModelAssembler implements RepresentationModelAssembler<BoletaDTO, EntityModel<BoletaDTO>> {
    @Override
    public EntityModel<BoletaDTO> toModel(BoletaDTO entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(BoletaControllerV2.class).findBoletaById(entity.getId())).withSelfRel(),
                linkTo(methodOn(BoletaControllerV2.class).findAll()).withRel("boletas")
        );
    }
}
