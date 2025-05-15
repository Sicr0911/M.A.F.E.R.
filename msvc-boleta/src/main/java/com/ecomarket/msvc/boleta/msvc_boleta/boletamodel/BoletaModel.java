package com.ecomarket.msvc.boleta.msvc_boleta.boletamodel;

import lombok.*;

@Getter @Setter@ToString
@NoArgsConstructor @AllArgsConstructor
public class BoletaModel {
        private Long IdBoleta;
        private String Descripcion;
        private String Nombre;
        private Double Precio;
}
