package com.ecomarket.msvc.sucursal.msvc.sucursal.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity
@Schema(description = "Entidad de sucursal")
@Table(name="sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_sucursal", nullable = false, unique = true)
    @Schema(description = "primary key sucursal", example = "1")
    private Long idSucursal;

    @Column(nullable = false)
    @NotBlank(message = "El campo nombre no puede ser vacio")
    @Schema(description = "nombre sucursal", example = "Vecino del bolsillo", required = true)
    private String nombre;

    @Column(nullable = false)
    @NotBlank(message = "El campo direccion no puede ser vacio")
    @Schema(description = "direccion sucursal", example = "Viña del mar", required = true)
    private String direccion;

    @Schema(description = "numero sucursal", example = "1234567898")
    private String telefono;

}
