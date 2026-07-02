package br.senac.prjint3.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Projeto Integrador 3")
                        .version("1.0.0")
                        .description("API REST em Java 21 com Spring Boot, MySQL, JPA e Swagger."));
    }
}
