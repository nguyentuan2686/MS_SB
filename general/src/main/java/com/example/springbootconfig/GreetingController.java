package com.example.springbootconfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${greeting}")
    private final String greetingMess;

    @Value("classpath:keycloak.json")
    private Resource keycloak;

    @Autowired
    private RedisTemplate<String,String> template;

    private final DbSetting dbSetting;

    private GreetingController(@Value("${greeting}") String greetingMess, DbSetting setting) {
        this.greetingMess = greetingMess;
        dbSetting = setting;
    }

    @GetMapping("/greeting")
    public String getGreeting() throws IOException {
        InputStream inputStream = keycloak.getInputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> keycloakMap  = objectMapper.readValue(inputStream, Map.class);
        String secret = (String) keycloakMap.get("secret");
        System.out.println(keycloak.getURI() + " " + keycloak.exists()+ " " + secret);
        System.out.println(dbSetting);
        System.out.println(template);
        template.opsForValue().set("loda","hello world");
        return greetingMess;
    }
}
