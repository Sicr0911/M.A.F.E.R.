package com.ecomarket.msvc.producto.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="producto")

public class Producto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false, unique = true)
    private Long idProducto;

    @Column(nullable = false)
    @NotBlank(message = "El campo nombre no puede ser vacio")
    @NotNull(message = "Nombre no puede ser vacio")
    private String nombre;

    @Column(nullable = false)
    @NotBlank(message = "El campo descripcion no puede ser vacio")
    private String descripcion;

    @Column(nullable = false)
    private Long stock;

}
