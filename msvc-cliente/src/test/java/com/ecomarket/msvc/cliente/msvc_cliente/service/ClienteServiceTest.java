package com.ecomarket.msvc.cliente.msvc_cliente.service;

import com.ecomarket.msvc.cliente.msvc_cliente.exceptions.ClienteException;
import com.ecomarket.msvc.cliente.msvc_cliente.model.Cliente;
import com.ecomarket.msvc.cliente.msvc_cliente.repositories.ClienteRepository;
import com.ecomarket.msvc.cliente.msvc_cliente.services.ClienteService;
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
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository ;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente clientePrueba;

    private List<Cliente> clientes = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        Faker faker = new Faker(Locale.of("es", "CL"));

        for  (int i = 0; i < 100; i++) {

            Cliente cliente = new Cliente();
            cliente.setIdCliente((long) i);
            cliente.setNombreCompleto(faker.name().fullName());
            cliente.setCorreo(faker.address().fullAddress());

            String numeroString = faker.idNumber().valid().replaceAll("-","");
            String ultimo = numeroString.substring(numeroString.length()-1);
            String restante = numeroString.substring(0,numeroString.length()-1);
            cliente.setRunCliente(restante+"-"+ultimo);

            this.clientes.add(cliente);
        }
        this.clientePrueba = new Cliente(
                1L, "11111111-1", "Juanito Alcachofa", "juan.alca@gmail.com"
        );
    }

    @Test
    @DisplayName("Debe listar todos las sucursales")
    public void shouldFindAllSucursales() {
        this.clientes.add(this.clientePrueba) ;

        when(clienteRepository.findAll()).thenReturn(this.clientes);

        List<Cliente> resultado = clienteService.findAll();

        assertThat(resultado).hasSize(101);
        assertThat(resultado).contains(this.clientePrueba);

        verify(clienteRepository, times(1)).findAll();

    }

    @Test
    @DisplayName("Debe encontrar una sucursal por id")
    public void shouldFindSucursalById() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(this.clientePrueba));

        Cliente result = clienteService.findById(1L);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(this.clientePrueba);

        verify(clienteRepository,times(1)).findById(1L);

    }

    @Test
    @DisplayName("Debe entregar una excepcion cuando medico id no exista")
    public void shouldNotFindSucursalById(){
        Long idInexistente = 999L;

        when(clienteRepository.findById(idInexistente)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> {
            clienteService.findById(idInexistente);

        }).isInstanceOf(ClienteException.class)
                .hasMessageContaining("El medico con id " + idInexistente
                        + " no se encuentra en la base de datos");

        verify(clienteRepository, times(1)).findById(idInexistente);
    }

    @Test
    @DisplayName("Debe guardar un nuevo medico")
    public void shouldSaveMedico(){
        when(clienteRepository.save(any(Cliente.class))).thenReturn(this.clientePrueba);

        Cliente result = clienteService.save(this.clientePrueba);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(this.clientePrueba);

        verify(clienteRepository, times(1)).save(any(Cliente.class));
    }

}
