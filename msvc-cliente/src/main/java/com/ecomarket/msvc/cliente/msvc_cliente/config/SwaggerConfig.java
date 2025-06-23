package com.ecomarket.msvc.cliente.msvc_cliente.config;

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
                        .title("Api  - MSVC - Cliente")
                        .description("Esta es la api dedicada al msvc de cliente.")
                        .version("1.0.0")
                );
    }
}
