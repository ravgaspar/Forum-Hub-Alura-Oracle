package br.com.desafio.forumhub.infraestrutura.springDoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("Fórum Hub")
                        .description("API Rest da aplicação Fórum Hub, contendo as funcionalidades de CRUD de usuários, tópicos, cursos e respostas.")
                        .contact(new Contact()
                                .name("Joesley Cálita")
                                .email("joesleycalita@gmail.com"))
                );
    }
}