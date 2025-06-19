package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.service;

import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.clients.BoletaClientsRest;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.clients.ProductoClientsRest;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.Boleta;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.Producto;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.entities.DetalleCompra;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.repositories.DetalleCompraRepository;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.services.DetalleCompraServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DetalleCompraServiceTest {

    @Mock
    private BoletaClientsRest boletaClientsRest;

    @Mock
    private ProductoClientsRest productoClientsRest;

    @Mock
    private DetalleCompraRepository detalleCompraRepository;

    @InjectMocks
    private DetalleCompraServiceImpl detalleCompraService;

    private Boleta boletaPrueba;
    private Producto productoPrueba;
    private DetalleCompra detalleCompraPrueba;

    @BeforeEach
    public void setUp() {
        boletaPrueba = new Boleta(
            1L,
            LocalDateTime.now(),
            "Cantidad de productos:"
        );

        productoPrueba = new Producto(
                1L,
                "Atún",
                "Lata",
                "1.500"
        );

        detalleCompraPrueba = new DetalleCompra(
                1L,
                5,
                1500,
                "Atún",
                1L,
                1L,
                LocalDate.of(2025,6,18)
        );
    }

    @Test
    @DisplayName("Se debe guardar una atención")
    public void shouldCreateDetalleCompra() {
        when(boletaClientsRest.findById(1L)).thenReturn(this.boletaPrueba);
        when(productoClientsRest.findById(1L)).thenReturn(this.productoPrueba);
        when(detalleCompraRepository.save(any(DetalleCompra.class))).thenReturn(this.detalleCompraPrueba);

        DetalleCompra result = detalleCompraService.save(this.detalleCompraPrueba);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(this.detalleCompraPrueba);

        verify(boletaClientsRest,times(1)).findById(1L);
        verify(productoClientsRest,times(1)).findById(1L);
        verify(detalleCompraRepository, times(1)).save(any(DetalleCompra.class));

    }

}