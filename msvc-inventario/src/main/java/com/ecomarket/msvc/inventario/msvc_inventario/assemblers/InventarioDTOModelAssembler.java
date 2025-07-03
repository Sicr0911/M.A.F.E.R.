package com.ecomarket.msvc.inventario.msvc_inventario.assemblers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import com.ecomarket.msvc.inventario.msvc_inventario.controllers.InventarioControllerV2;
import com.ecomarket.msvc.inventario.msvc_inventario.dtos.InventarioDTO;

@Component
public class InventarioDTOModelAssembler implements RepresentationModelAssembler<InventarioDTO, EntityModel<InventarioDTO>> {
    @Override
    public EntityModel<InventarioDTO> toModel(InventarioDTO entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(InventarioControllerV2.class).findById(entity.getId())).withSelfRel(),
                linkTo(methodOn(InventarioControllerV2.class).findAll()).withRel("inventarios"),
                Link.of("http://localhost:8005/api/v2/productos/"+entity.getIdProducto().getIdProducto()).withRel("producto"),
                Link.of("http://localhost:8006/api/v2/sucursales/"+entity.getIdSucursal().getIdSucursal()).withRel("sucursal")
        );
    }
}
