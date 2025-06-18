package com.ecomarket.msvc.boleta.msvc_boleta.init;

import com.ecomarket.msvc.boleta.msvc_boleta.model.entities.Boleta;
import com.ecomarket.msvc.boleta.msvc_boleta.repositories.BoletaRepositories;
import net.datafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Locale;

@Profile("dev")
@Component

public class LoadDatabase implements CommandLineRunner {
    @Autowired
    private BoletaRepositories boletaRepositories;

    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(Locale.of("es","CL"));
        if (boletaRepositories.count() == 0) {
            for (int i = 0; i < 10000; i++) {
                Boleta boleta = new Boleta();

                boleta.setIdBoleta(faker.random().nextLong());
                boleta.setDetalle(faker.commerce().productName());
                boleta.setIdSucursal(faker.random().nextLong());
                boleta.setIdDetalleCompra(faker.random().nextLong());
                boleta.setIdCliente(faker.random().nextLong());
                boleta.setHoraBoleta(LocalDateTime.now());

                boletaRepositories.save(boleta);

                logger.info("Boleta " + boleta.getIdBoleta() + " creada con exito");
            }
        }
    }
}
