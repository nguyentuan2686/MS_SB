package com.example.springbootconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("locale/message");
        source.setUseCodeAsDefaultMessage(true);
        source.setDefaultEncoding("UTF-8");
        return source;
    }
}
