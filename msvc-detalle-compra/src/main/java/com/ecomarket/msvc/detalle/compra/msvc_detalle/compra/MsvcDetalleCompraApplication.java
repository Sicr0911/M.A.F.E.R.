package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsvcDetalleCompraApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcDetalleCompraApplication.class, args);
	}

}
