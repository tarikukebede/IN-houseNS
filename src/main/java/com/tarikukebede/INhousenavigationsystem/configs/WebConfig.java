package com.tarikukebede.INhousenavigationsystem.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebConfig {
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**");
    }
}
