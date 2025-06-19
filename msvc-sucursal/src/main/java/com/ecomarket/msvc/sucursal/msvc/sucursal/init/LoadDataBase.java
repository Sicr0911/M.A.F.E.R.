package com.ecomarket.msvc.sucursal.msvc.sucursal.init;

import com.ecomarket.msvc.sucursal.msvc.sucursal.model.Sucursal;
import com.ecomarket.msvc.sucursal.msvc.sucursal.repositories.SucursalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import net.datafaker.Faker;
import java.util.Locale;

@Profile("dev")
@Component
public class LoadDataBase implements CommandLineRunner {

    @Autowired
    private SucursalRepository sucursalRepository;

    private static final Logger logger = LoggerFactory.getLogger(LoadDataBase.class);

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(Locale.of("es","CL"));
        if (sucursalRepository.count() == 0) {
            for (int i = 0; i < 10; i++) {
                Sucursal sucursal = new Sucursal();

                sucursal.setIdSucursal(faker.random().nextLong());
                sucursal.setNombre(faker.name().fullName());
                sucursal.setDireccion(faker.address().fullAddress());
                sucursal.setTelefono(faker.phoneNumber().phoneNumber());

                sucursal = sucursalRepository.save(sucursal);
                logger.info(sucursal.toString());
            }
        }
    }
}
