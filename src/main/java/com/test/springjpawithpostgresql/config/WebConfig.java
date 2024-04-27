package com.test.springjpawithpostgresql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private CorsProperties corsProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(corsProperties.getAllowedOrigins().split(","))
                .allowedMethods(corsProperties.getAllowedMethods().split(","))
                .allowedHeaders(corsProperties.getAllowedHeaders().split(","))
                .exposedHeaders(corsProperties.getExposedHeaders().split(","))
                .allowCredentials(corsProperties.isAllowCredentials())
                .maxAge(corsProperties.getMaxAge());
    }
}

