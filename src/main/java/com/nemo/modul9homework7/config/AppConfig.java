package com.nemo.modul9homework7.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "spring")
@Getter
@Setter
public class AppConfig {

    private Config config;


    public static class Config {
        private String name;
        private String environment;
        private boolean enabled;
        private List<String> servers;

    }
}

