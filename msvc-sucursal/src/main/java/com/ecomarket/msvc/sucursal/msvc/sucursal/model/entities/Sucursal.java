package com.ecomarket.msvc.sucursal.msvc.sucursal.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name="sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_sucursal", nullable = false, unique = true)
    private Long idSucursal;

    @Column(nullable = false)
    @NotBlank(message = "El campo nombre no puede ser vacio")
    private String nombre;

    @Column(nullable = false)
    @NotBlank(message = "El campo direccion no puede ser vacio")
    private String direccion;

    private String telefono;

}
