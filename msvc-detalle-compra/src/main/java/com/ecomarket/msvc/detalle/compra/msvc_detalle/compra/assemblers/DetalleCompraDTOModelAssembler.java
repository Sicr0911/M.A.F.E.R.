package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.assemblers;

import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.Controller.DetalleCompraControllerV2;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos.DetalleCompraDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DetalleCompraDTOModelAssembler implements RepresentationModelAssembler<DetalleCompraDTO, EntityModel<DetalleCompraDTO>> {
    @Override
    public EntityModel<DetalleCompraDTO> toModel(DetalleCompraDTO entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(DetalleCompraControllerV2.class).findById(entity.getId())).withSelfRel(),
                linkTo(methodOn(DetalleCompraControllerV2.class).findAll()).withRel("detalle-compras"),
                Link.of("http://localhost:8001/api/v2/boletas/"+entity.getIdBoleta().getId()).withRel("boleta"),
                Link.of("http://localhost:8005/api/v2/productos/"+entity.getIdProducto().getIdProducto()).withRel("producto")
        );
    }
}
