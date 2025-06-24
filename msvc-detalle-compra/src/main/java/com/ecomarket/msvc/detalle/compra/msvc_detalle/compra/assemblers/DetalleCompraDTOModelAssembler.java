package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.assemblers;

import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.Controller.DetalleCompraControllerV2;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos.DetalleCompraDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class DetalleCompraDTOModelAssembler implements RepresentationModelAssembler<DetalleCompraDTO, EntityModel<DetalleCompraDTO>> {
    @Override
    public EntityModel<DetalleCompraDTO> toModel(DetalleCompraDTO entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(DetalleCompraControllerV2.class).findByBoletaId(entity.getIdDetalleCompra())).withRel("detalleCompra")
        );
    }
}
