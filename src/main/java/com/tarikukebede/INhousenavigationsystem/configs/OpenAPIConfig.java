package com.tarikukebede.INhousenavigationsystem.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Value("${api.version}")
    private String apiVersion;
    @Value("${spring.application.name}")
    private String appName;

    @Bean
    public OpenAPI Config(){
        return new OpenAPI().info(new Info().title(appName).version(apiVersion));
    }
}
