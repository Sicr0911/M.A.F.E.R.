package com.ecomarket.msvc.cliente.msvc_cliente.init;

import com.ecomarket.msvc.cliente.msvc_cliente.model.Cliente;
import com.ecomarket.msvc.cliente.msvc_cliente.repositories.ClienteRepository;
import net.datafaker.Faker;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.logging.Logger;

@Profile("dev")
@Component
public class LoadDatabase implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(LoadDatabase.class);

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(Locale.of("es","Cl"));
        if (clienteRepository.count() == 0) {
            for (int i = 0; i < 10; i++) {
                Cliente cliente = new Cliente();

                cliente.setIdCliente(faker.random().nextLong());
                cliente.setRunCliente(faker.idNumber().valid().replaceAll("-",""));
                cliente.setNombreCompleto(faker.name().fullName());
                cliente.setCorreo(faker.name().username());
                cliente = clienteRepository.save(cliente);
                logger.info("Cliente encontrado: " + cliente.getNombreCompleto());
            }
        }
    }
}
