package com.ecomarket.msvc.cliente.msvc_cliente.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Table(name = "Ficha_Paciente")
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class FichaPaciente {

    @Id
    @Column(name = "id_ficha_cliente")
    private Long idFichaCliente;

    @Column(nullable = false, length = 250)
    @NotBlank(message = "El campo datos personales no puede estar vacio")
    private String datosPersonales;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_paciente", nullable = false)
    private Cliente cliente;
}
