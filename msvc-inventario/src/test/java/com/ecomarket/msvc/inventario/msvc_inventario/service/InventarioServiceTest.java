package com.ecomarket.msvc.inventario.msvc_inventario.service;

import com.ecomarket.msvc.inventario.msvc_inventario.clients.ProductoClientsRest;
import com.ecomarket.msvc.inventario.msvc_inventario.clients.SucursalClientsRest;
import com.ecomarket.msvc.inventario.msvc_inventario.models.Producto;
import com.ecomarket.msvc.inventario.msvc_inventario.models.Sucursal;
import com.ecomarket.msvc.inventario.msvc_inventario.models.entities.Inventario;
import com.ecomarket.msvc.inventario.msvc_inventario.repositories.InventarioRepository;
import com.ecomarket.msvc.inventario.msvc_inventario.services.InventarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InventarioServiceTest {

    @Mock
    private SucursalClientsRest sucursalClientsRest;

    @Mock
    private ProductoClientsRest productoClientsRest;

    @Mock
    private InventarioRepository inventarioRepository;

    @InjectMocks
    private InventarioServiceImpl inventarioService;

    private Sucursal sucursalPrueba;
    private Producto productoPrueba;
    private Inventario inventarioPrueba;

    @BeforeEach
    public void setUp() {
        sucursalPrueba = new Sucursal(
            1L,
            "Jefe del ahorro",
            "Valparaiso",
            "123456789"
        );

        productoPrueba = new Producto(
                1L,
                "Atún",
                "Lata",
                "1.500"
        );

        inventarioPrueba = new Inventario(
                1L,
                1500,
                "Producto: ",
                1L,
                1L
        );
    }

    @Test
    @DisplayName("Se debe guardar un detalle")
    public void shouldCreateDetalleCompra() {
        when(sucursalClientsRest.findById(1L)).thenReturn(this.sucursalPrueba);
        when(productoClientsRest.findById(1L)).thenReturn(this.productoPrueba);
        when(inventarioRepository.save(any(Inventario.class))).thenReturn(this.inventarioPrueba);

        Inventario result = inventarioService.save(this.inventarioPrueba);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(this.inventarioPrueba);

        verify(sucursalClientsRest,times(1)).findById(1L);
        verify(productoClientsRest,times(1)).findById(1L);
        verify(inventarioRepository, times(1)).save(any(Inventario.class));

    }
}