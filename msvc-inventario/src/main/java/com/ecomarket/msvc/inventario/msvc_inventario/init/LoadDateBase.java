package com.ecomarket.msvc.inventario.msvc_inventario.init;

import com.ecomarket.msvc.inventario.msvc_inventario.models.entities.Inventario;
import com.ecomarket.msvc.inventario.msvc_inventario.repositories.InventarioRepository;
import net.datafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Profile("dev")
@Component
public class LoadDateBase implements CommandLineRunner {

    @Autowired
    private InventarioRepository inventarioRepository;

    private static final Logger logger = LoggerFactory.getLogger(LoadDateBase.class);

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(Locale.of("es","CL"));
        if (inventarioRepository.count() == 0){
            for (int i = 0; i < 10; i++){
                Inventario inventario = new Inventario();

                inventario.setIdInventario(faker.random().nextLong());
                inventario.setCosto(faker.random().nextInt());
                inventario.setComentario(faker.random().toString());
                inventario.setIdProducto(faker.random().nextLong());
                inventario.setIdSucursal(faker.random().nextLong());

                inventario = inventarioRepository.save(inventario);
                logger.info(inventario.getIdInventario().toString());
            }
        }
    }
}
