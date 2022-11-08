package com.sportconnect.teamsservice.config.axonconfiguration;


import com.sportconnect.teamsservice.command.interceptors.CreateTeamCommandInterceptor;
import com.sportconnect.teamsservice.core.errorhandling.TeamsServiceEventsErrorHandler;
import com.thoughtworks.xstream.XStream;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
                "com.sportconnect.teammanagerservice.**",
                "**"
        });
        return xStream;
    }



}
