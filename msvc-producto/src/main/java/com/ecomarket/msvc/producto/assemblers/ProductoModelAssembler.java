package com.ecomarket.msvc.producto.assemblers;

import com.ecomarket.msvc.producto.controller.ProductoControllerV2;
import com.ecomarket.msvc.producto.models.Producto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductoModelAssembler implements RepresentationModelAssembler<Producto, EntityModel<Producto>> {
    @Override
    public EntityModel<Producto> toModel(Producto entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(ProductoControllerV2.class).findById(entity.getIdProducto())).withSelfRel(),
                linkTo(methodOn(ProductoControllerV2.class).findAll()).withRel("producto"),
                Link.of("http://localhost:8005/sucursal/"+entity.getIdProducto()).withRel("producto")
            );
        }
}
