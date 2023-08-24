package com.example.springbootconfig;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "db")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DbSetting {
    private String connection;
    private String host;
    private int port;
}
