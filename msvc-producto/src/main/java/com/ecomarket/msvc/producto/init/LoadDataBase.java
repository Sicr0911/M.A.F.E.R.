package com.ecomarket.msvc.producto.init;

import com.ecomarket.msvc.producto.models.Producto;
import com.ecomarket.msvc.producto.repositories.ProductoRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.logging.Logger;

@Profile("dev")
@Component
public class LoadDataBase implements CommandLineRunner {

    @Autowired
    private ProductoRepository productoRepository;

    private static final Logger logger = Logger.getLogger(LoadDataBase.class.getName());

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(Locale.of("es","CL"));
        if (productoRepository.count() == 0) {
            for (int i = 0; i < 10; i++) {
                Producto producto = new Producto();

                producto.setNombre(faker.name().fullName());
                producto.setDescripcion(faker.book().title());
                producto.setIdProducto(faker.random().nextLong());
                producto.setStock(faker.random().nextInt());

                producto = productoRepository.save(producto);
                logger.info(producto.toString());
            }
        }
    }




}
