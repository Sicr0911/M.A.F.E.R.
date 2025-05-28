package com.ecomarket.msvc.inventario.msvc_inventario.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "inventario")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private Long idInventario;

    @Column(nullable = false)
    @NotBlank(message = "El campo no puede ser vacio")
    private Integer costo;

    private String comentario;

    @Column(name = "id_producto", nullable = false)
    @NotNull(message = "El campo id boleta no puede ser vacio")
    private Long idProducto;

    @Column(nullable = false, name = "id_sucursal")
    @NotNull(message = "El campo id cliente no puede ser vacio")
    private Long idSucursal;


}
