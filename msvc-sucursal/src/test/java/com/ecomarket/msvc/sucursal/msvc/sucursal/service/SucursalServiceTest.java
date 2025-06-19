package com.ecomarket.msvc.sucursal.msvc.sucursal.service;

import com.ecomarket.msvc.sucursal.msvc.sucursal.exceptions.SucursalException;
import com.ecomarket.msvc.sucursal.msvc.sucursal.model.Sucursal;
import com.ecomarket.msvc.sucursal.msvc.sucursal.repositories.SucursalRepository;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SucursalServiceTest {

    @Mock
    private SucursalRepository sucursalRepository ;

    @InjectMocks
    private SucursalServiceImpl sucursalService;

    private Sucursal sucursalPrueba;

    private List<Sucursal> sucursales = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        Faker faker = new Faker(Locale.of("es", "CL"));

        for  (int i = 0; i < 100; i++) {

            Sucursal sucursal = new Sucursal();
            sucursal.setIdSucursal((long) i);
            sucursal.setNombre(faker.name().fullName());
            sucursal.setDireccion(faker.address().fullAddress());
            sucursal.setTelefono(faker.phoneNumber().phoneNumber());

            this.sucursales.add(sucursal);
        }
        this.sucursalPrueba = new Sucursal(
                1L, "Vecino del ahorro", "Viña del mar", "123456789"
        );
    }

    @Test
    @DisplayName("Debe listar todos las sucursales")
    public void shouldFindAllSucursales() {
        this.sucursales.add(this.sucursalPrueba) ;

        when(sucursalRepository.findAll()).thenReturn(this.sucursales);

        List<Sucursal> resultado = sucursalService.findAll();

        assertThat(resultado).hasSize(101);
        assertThat(resultado).contains(this.sucursalPrueba);

        verify(sucursalRepository, times(1)).findAll();

    }

    @Test
    @DisplayName("Debe encontrar una sucursal por id")
    public void shouldFindSucursalById() {
        when(sucursalRepository.findById(1L)).thenReturn(Optional.of(this.sucursalPrueba));

        Sucursal result = sucursalService.findById(1L);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(this.sucursalPrueba);

        verify(sucursalRepository,times(1)).findById(1L);

    }

    @Test
    @DisplayName("Debe entregar una excepcion cuando sucursal id no exista")
    public void shouldNotFindSucursalById(){
        Long idInexistente = 999L;

        when(sucursalRepository.findById(idInexistente)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> {
            sucursalService.findById(idInexistente);

        }).isInstanceOf(SucursalException.class)
                .hasMessageContaining("La sucursal con id " + idInexistente
                        + " no se encuentra en la base de datos");

        verify(sucursalRepository, times(1)).findById(idInexistente);
    }

    @Test
    @DisplayName("Debe guardar una nueva sucursal")
    public void shouldSaveSucursal(){
        when(sucursalRepository.save(any(Sucursal.class))).thenReturn(this.sucursalPrueba);

        Sucursal result = sucursalService.save(this.sucursalPrueba);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(this.sucursalPrueba);

        verify(sucursalRepository, times(1)).save(any(Sucursal.class));
    }

}
