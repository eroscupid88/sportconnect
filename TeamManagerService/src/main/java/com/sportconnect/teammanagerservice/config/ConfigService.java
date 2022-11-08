package com.sportconnect.teammanagerservice.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Method to pass configuration from config server
 */
@Component
@Getter
@Setter
public class ConfigService {
    // todo
    private String property;

    @Value("${redis.server}")
    private String redisServer="";

    @Value("${redis.port}")
    private String redisPort="";
}
