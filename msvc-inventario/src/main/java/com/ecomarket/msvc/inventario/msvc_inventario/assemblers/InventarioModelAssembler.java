package com.ecomarket.msvc.inventario.msvc_inventario.assemblers;

import com.ecomarket.msvc.inventario.msvc_inventario.controllers.InventarioControllerV2;
import com.ecomarket.msvc.inventario.msvc_inventario.models.entities.Inventario;
import io.swagger.v3.oas.models.links.Link;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class InventarioModelAssembler {
    @Override
    public EntityModel<Inventario> toModel(Inventario entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(InventarioControllerV2.class).findById(entity.get)).withSelfRel(),
                linkTo(methodOn(InventarioControllerV2.class).findAll()).withRel("inventario"),
                Link.of("http://localhost:8005/inventario/"+entity.get).withRel("inventario")
        );
    }
}
