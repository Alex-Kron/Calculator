package com.alexkron.calculator.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("NeoFlex Calculator")
                                .description("Calculator application that implements the REST API")
                                .contact(
                                        new Contact()
                                                .name("Almukhamedov Aleksei")
                                                .email("aleksei.alm@gmail.com")
                                )
                );
    }
}
