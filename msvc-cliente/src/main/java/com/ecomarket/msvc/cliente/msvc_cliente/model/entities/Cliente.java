package com.ecomarket.msvc.cliente.msvc_cliente.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "clientes")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false, unique = true)
    private Long idCliente ;

    @Column(name = "run_cliente", nullable = false, unique = true)
    @Pattern(regexp = "\\d{1,8}-[\\dkK]", message = "El formato del run del cliente debe ser, ej: 12345678-0")
    private String runCliente ;

    @Column(name = "nombre_completo", nullable = false)
    @NotBlank(message = "El campo no puede ser vacio")
    private String nombreCompleto ;

    @Column(nullable = false)
    private String correo ;

    @Column(name = "id_detalle_compra", nullable = false)
    @NotNull(message = "El campo no puede ser vacio")
    private Long idDetalleCompra;

    @Column(name = "id_sucursal", nullable = false)
    @NotNull(message = "El campo no puede ser vacio")
    private Long idSucursal;

}
