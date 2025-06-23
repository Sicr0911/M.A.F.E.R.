package com.ecomarket.msvc.sucursal.msvc.sucursal.config;

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
                        .title("Api  - MSVC - Sucursal")
                        .description("Esta es la api dedicada al msvc de sucursal")
                        .version("1.0.0")
                );
    }
}
