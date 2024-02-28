package com.beyond.infinity.demo.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProperties {

    @Bean
    @ConfigurationProperties(prefix="jira")
    public JiraConfig jira(){
        return new JiraConfig();

    }

    @Bean
    @ConfigurationProperties(prefix="conf")
    public JiraConfig confluence(){
        return new JiraConfig();

    }
}
