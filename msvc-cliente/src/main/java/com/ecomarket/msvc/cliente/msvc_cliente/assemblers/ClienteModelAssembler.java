package com.ecomarket.msvc.cliente.msvc_cliente.assemblers;

import com.ecomarket.msvc.cliente.msvc_cliente.controllers.ClienteControllerV2;
import com.ecomarket.msvc.cliente.msvc_cliente.model.Cliente;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ClienteModelAssembler implements RepresentationModelAssembler<Cliente, EntityModel<Cliente>> {
    @Override
    public EntityModel<Cliente> toModel(Cliente entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(ClienteControllerV2.class).findById(entity.getIdCliente())).withSelfRel(),
                linkTo(methodOn(ClienteControllerV2.class).findAll()).withRel("cliente"),
                Link.of("http://localhost:8002/sucursal/" + entity.getIdCliente()).withRel("cliente")
        );
    }
}
