package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="detalle_compras")
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_compra", nullable = false, unique = true)
    private Long idDetalleCompra;

    @Column(name = "cantidad_total", nullable = false)
    @NotNull(message = "Debe ingresar valores")
    private Integer cantTotal;

    @Column(nullable = false)
    @NotNull(message = "Debe ingresar valores")
    private Integer precio;

    @Column(nullable = false)
    private String producto ;

    @Column(name = "id_boleta", nullable = false)
    private Long idBoleta;

    @Column(name = "id_producto", nullable = false)
    private Long idProducto;

    @Column(nullable = false)
    private LocalDate fecha;

}