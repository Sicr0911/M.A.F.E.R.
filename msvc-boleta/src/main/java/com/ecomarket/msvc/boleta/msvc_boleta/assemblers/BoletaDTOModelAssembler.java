package com.ecomarket.msvc.boleta.msvc_boleta.assemblers;

import com.ecomarket.msvc.boleta.msvc_boleta.controller.BoletaControllerV2;
import com.ecomarket.msvc.boleta.msvc_boleta.dtos.BoletaDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
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
                linkTo(methodOn(BoletaControllerV2.class).findById(entity.getIdBoleta())).withSelfRel(),
                linkTo(methodOn(BoletaControllerV2.class).findAll()).withRel("boletas"),
                Link.of("http://localhost:8002/api/v2/clientes/"+entity.getCliente().getId()).withRel("cliente"),
                Link.of("http://localhost:800+/api/v2/sucursales/"+entity.getSucursal().getIdSucursal()).withRel("sucursal")
        );
    }
}
