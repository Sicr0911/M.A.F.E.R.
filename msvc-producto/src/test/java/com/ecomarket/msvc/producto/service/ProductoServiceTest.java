package com.ecomarket.msvc.producto.service;

import com.ecomarket.msvc.producto.exceptions.ProductoException;
import com.ecomarket.msvc.producto.models.Producto;
import com.ecomarket.msvc.producto.repositories.ProductoRepository;
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
public class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository ;

    @InjectMocks
    private ProductoServiceImpl productoService;

    private Producto productoPrueba;

    private List<Producto> productos = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        Faker faker = new Faker(Locale.of("es", "CL"));

        for  (int i = 0; i < 100; i++) {

            Producto producto = new Producto();

            producto.setIdProducto((long) i);
            producto.setNombre(faker.food().ingredient());
            producto.setDescripcion(faker.bothify("Producto: ####"));
            producto.setStock(faker.number().numberBetween(1,100));

            this.productos.add(producto);
        }
        this.productoPrueba = new Producto(
                1L, "Salmón", "Pescado", 92
        );
    }

    @Test
    @DisplayName("Debe listar todos las sucursales")
    public void shouldFindAllSucursales() {
        this.productos.add(this.productoPrueba) ;

        when(productoRepository.findAll()).thenReturn(this.productos);

        List<Producto> resultado = productoService.findAll();

        assertThat(resultado).hasSize(101);
        assertThat(resultado).contains(this.productoPrueba);

        verify(productoRepository, times(1)).findAll();

    }

    @Test
    @DisplayName("Debe encontrar una sucursal por id")
    public void shouldFindSucursalById() {
        when(productoRepository.findById(1L)).thenReturn(Optional.of(this.productoPrueba));

        Producto result = productoService.findById(1L);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(this.productoPrueba);

        verify(productoRepository,times(1)).findById(1L);

    }

    @Test
    @DisplayName("Debe entregar una excepcion cuando medico id no exista")
    public void shouldNotFindSucursalById(){
        Long idInexistente = 999L;

        when(productoRepository.findById(idInexistente)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> {
            productoService.findById(idInexistente);

        }).isInstanceOf(ProductoException.class)
                .hasMessageContaining("El medico con id " + idInexistente
                        + " no se encuentra en la base de datos");

        verify(productoRepository, times(1)).findById(idInexistente);
    }

    @Test
    @DisplayName("Debe guardar un nuevo medico")
    public void shouldSaveMedico(){
        when(productoRepository.save(any(Producto.class))).thenReturn(this.productoPrueba);

        Producto result = productoService.save(this.productoPrueba);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(this.productoPrueba);

        verify(productoRepository, times(1)).save(any(Producto.class));
    }

}
