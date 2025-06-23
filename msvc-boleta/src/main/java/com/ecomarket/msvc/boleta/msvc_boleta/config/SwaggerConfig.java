package com.ecomarket.msvc.boleta.msvc_boleta.config;

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
                        .title("Api  - MSVC - Boleta")
                        .description("Esta es la api dedicada al msvc de boleta.")
                        .version("1.0.0")
                );
    }
}