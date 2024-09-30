package com.leucinetech.college_directory.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Sudharshan
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1/auth/signin")
                .allowedOrigins("http://127.0.0.1:5500") // Allow all origins
                .allowedMethods("POST")
                .allowedHeaders("*")
                .allowCredentials(false); // Set to true only if using cookies/auth tokens
    }
}
