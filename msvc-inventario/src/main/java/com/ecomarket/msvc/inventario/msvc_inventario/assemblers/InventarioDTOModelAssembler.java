package com.ecomarket.msvc.inventario.msvc_inventario.assemblers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import com.ecomarket.msvc.inventario.msvc_inventario.controllers.InventarioControllerV2;
import com.ecomarket.msvc.inventario.msvc_inventario.dtos.InventarioDTO;

public class InventarioDTOModelAssembler {
    @Override
    public EntityModel<InventarioDTO> toModel(InventarioDTO entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(InventarioControllerV2.class).findById(entity.getProducto())).withRel("inventario-poducto")
        );
    }
}
