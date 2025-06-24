package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.assemblers;

import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.Controller.DetalleCompraControllerV2;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.entities.DetalleCompra;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DetalleCompraModelassembler implements RepresentationModelAssembler<DetalleCompra, EntityModel<DetalleCompra>> {
    @Override
    public EntityModel<DetalleCompra> toModel(DetalleCompra entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(DetalleCompraControllerV2.class).findById(entity.getIdProducto())).withSelfRel(),
                linkTo(methodOn(DetalleCompraControllerV2.class).findAll()).withRel("producto"),
                Link.of("http://localhost:8005/productos/"+entity.getIdProducto()).withRel("producto")
        );
    }
}
