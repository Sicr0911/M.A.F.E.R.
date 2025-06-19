package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.init;

import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.model.entities.DetalleCompra;
import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.repositories.DetalleCompraRepository;
import net.datafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

@Profile("dev")
@Component
public class LoadDatabase implements CommandLineRunner {

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    LocalDateTime now = LocalDateTime.now();
    Date fecha = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(Locale.of("es","CL"));
        if(detalleCompraRepository.count() == 0) {
            for (int i = 0; i < 10; i++) {
                DetalleCompra detalleCompra = new DetalleCompra();

                detalleCompra.setIdDetalleCompra(faker.random().nextLong());
                detalleCompra.setCantTotal(faker.random().nextInt(1000));
                detalleCompra.setPrecio(faker.random().nextInt());
                detalleCompra.setProducto(null);
                detalleCompra.setIdBoleta(faker.random().nextLong());
                detalleCompra.setIdProducto(faker.random().nextLong());
                detalleCompra.setFecha(fecha);

                detalleCompra = detalleCompraRepository.save(detalleCompra);
                log.info(detalleCompra.toString());
            }
        }


    }
}
