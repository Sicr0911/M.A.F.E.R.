package com.ecomarket.msvc.inventario.msvc_inventario.inventariomodel.entities;


import com.ecomarket.msvc.inventario.msvc_inventario.inventariomodel.Inventario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "ficha_inventario")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class FichaInventario {

    @Id
    @Column(name="id_ficha_inventario")
    private Long idFichaInventario;

    @Column(nullable = false, length = 250)
    @NotBlank(message = "El campo datos personales no puede ser vacio")
    private String datosPersonales;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_inventario", nullable = false)
    private Inventario inventario;

}
