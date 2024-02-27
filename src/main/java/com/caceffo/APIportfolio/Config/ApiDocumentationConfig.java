package com.caceffo.APIportfolio.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDocumentationConfig {

    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("i18n API portfolio")
                        .description("This API works for create, delete, and get personal information about me, like projects, work experience and more.")
                        .version("1.0")
                        .contact(new Contact()
                                .name("JuanCaceffo")
                                .email("caceffojuan@gmail.com")));
    }
}