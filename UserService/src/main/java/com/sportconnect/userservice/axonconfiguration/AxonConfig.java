package com.sportconnect.userservice.axonconfiguration;


import com.thoughtworks.xstream.XStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AxonConfig {
    @Bean
    public XStream mySecuredXStream() {
        XStream xStream = new XStream();
        xStream.allowTypesByWildcard(new String[]{
                "com.sportconnect.**",
                "com.sportconnect.teamsservice.**",
                "com.sportconnect.teamrosterservice.**",
                "com.sportconnect.core.**",
                "com.sportconnect.userservice.**",
                "**"
        });
        return xStream;
    }



}
