package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Api  - MSVC - Detalle Compra")
                        .description("Esta es la api dedicada al msvc de detalle de compra.")
                        .version("1.0.0")
                );
    }
}
