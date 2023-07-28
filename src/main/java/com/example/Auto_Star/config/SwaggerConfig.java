package com.example.Auto_Star.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("Bearer Token", apiKeySecurityScheme()))
                .info(new Info().title("Auto Star API").version("1.0.0"));
    }
    private SecurityScheme apiKeySecurityScheme() {
        return new SecurityScheme()
                .name("Authorization")
                .description("Put your JWT token here!")
                .in(SecurityScheme.In.HEADER)
                .type(SecurityScheme.Type.APIKEY)
                .scheme("Bearer");
    }
}