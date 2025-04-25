package com.repositorio.repositorioWeb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Acepta todas las rutas del backend
                .allowedOrigins("*")  // Permite todos los orígenes
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Permite todos los métodos HTTP
                .allowedHeaders("*")  // Permite todos los encabezados
                .allowCredentials(true);  // Si usas cookies o credenciales
    }
}
