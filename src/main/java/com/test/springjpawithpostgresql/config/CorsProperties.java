package com.test.springjpawithpostgresql.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.web.cors")
public class CorsProperties {
    private boolean allowCredentials;
    private String allowedOrigins;
    private String allowedMethods;
    private String allowedHeaders;
    private String exposedHeaders;
    private long maxAge;

    // getters and setters
}
