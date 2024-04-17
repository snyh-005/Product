package io.github.snyh005.multibank.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI api() {
        OpenAPI openAPI = new OpenAPI();
        openAPI.setInfo(new Info()
                .title("Download Manager")
                .description("Java application that simulates a download manager capable of downloading multiple files concurrently.")
                .version("1.0"));
        openAPI.setServers(Collections.singletonList(new Server().url("http://localhost:8080")));
        openAPI.setPaths(new Paths());
        final String securitySchemeName = "bearer-key";
        openAPI.addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(
                        new Components()
                                .addSecuritySchemes(securitySchemeName,
                                        new SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")));
        return openAPI;
    }
}
