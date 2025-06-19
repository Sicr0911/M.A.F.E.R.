package com.ecomarket.msvc.boleta.msvc_boleta.service;

import com.ecomarket.msvc.boleta.msvc_boleta.clients.ClienteClientsRest;
import com.ecomarket.msvc.boleta.msvc_boleta.clients.DetalleCompraClientsRest;
import com.ecomarket.msvc.boleta.msvc_boleta.clients.SucursalClientsRest;
import com.ecomarket.msvc.boleta.msvc_boleta.model.Cliente;
import com.ecomarket.msvc.boleta.msvc_boleta.model.DetalleCompra;
import com.ecomarket.msvc.boleta.msvc_boleta.model.Sucursal;
import com.ecomarket.msvc.boleta.msvc_boleta.model.entities.Boleta;
import com.ecomarket.msvc.boleta.msvc_boleta.repositories.BoletaRepositories;
import com.ecomarket.msvc.boleta.msvc_boleta.services.BoletaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BoletaServiceTest {

    @Mock
    private ClienteClientsRest clienteClientsRest;

    @Mock
    private DetalleCompraClientsRest detalleCompraClientsRest;

    @Mock
    private SucursalClientsRest  sucursalClientsRest;

    @Mock
    private BoletaRepositories boletaRepositories;

    @InjectMocks
    private BoletaServiceImpl boletaService;

    private Cliente clientePrueba;
    private Boleta boletaPrueba;
    private Sucursal sucursalPrueba;
    private DetalleCompra detalleCompraPrueba;

    @BeforeEach
    public void setUp() {

        clientePrueba = new Cliente(
                1L,
                "12345678-9",
                "Juan carlos",
                "juan.carlos@gmail.com"
        );

        sucursalPrueba = new Sucursal(
                1L,
                "EL rey del ahorro",
                "Quilpue",
                "123456789"
        );

        detalleCompraPrueba = new DetalleCompra(
                1L,
                5,
                1500,
                "Jamón",
                1L,
                LocalDate.of(2025,6,18),
                "Jamón acaramelado"
        );

        boletaPrueba = new Boleta(
                1L,
                LocalDateTime.now(),
                "Cantidad: ",
                1L,
                1L,
                1L
        );
    }

    @Test
    @DisplayName("Se debe guardar una boleta")
    public void shouldCreateBoleta() {
        when(clienteClientsRest.findById(1L)).thenReturn(this.clientePrueba);
        when(sucursalClientsRest.findById(1L)).thenReturn(this.sucursalPrueba);
        when(detalleCompraClientsRest.findById(1L)).thenReturn(detalleCompraPrueba);
        when(boletaRepositories.save(any(Boleta.class))).thenReturn(this.boletaPrueba);

        Boleta result = boletaService.save(this.boletaPrueba);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(this.boletaPrueba);

        verify(clienteClientsRest,times(1)).findById(1L);
        verify(sucursalClientsRest,times(1)).findById(1L);
        verify(detalleCompraClientsRest,times(1)).findById(1L);
        verify(boletaRepositories, times(1)).save(any(Boleta.class));
    }
}