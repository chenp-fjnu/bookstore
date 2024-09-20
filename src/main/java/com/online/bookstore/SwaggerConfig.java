package com.online.bookstore;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("BookStore APIs")
                        .version("1.0")
                        .description("API Documentation for BookStore Application")
                        .termsOfService("https://github.com/chenp-fjnu")
                        .contact(new Contact()
                                        .name("Ping Chen")
                                        .url("https://github.com/chenp-fjnu")
                                        .email("11191162@qq.com"))
                );
    }
}
