package com.sportconnect.teamsservice;

import com.sportconnect.teamsservice.command.interceptors.CreateTeamCommandInterceptor;
import com.sportconnect.teamsservice.config.axonconfiguration.AxonConfig;
import com.sportconnect.teamsservice.config.locationconfiguration.LocationConfiguration;
import com.sportconnect.teamsservice.config.messagesourceconfiguration.MessageSourceConfiguration;
import com.sportconnect.teamsservice.config.redisconfiguration.RedisConfiguration;
import com.sportconnect.teamsservice.core.errorhandling.TeamsServiceEventsErrorHandler;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;



@EnableDiscoveryClient
@SpringBootApplication
@Import({AxonConfig.class,
        LocationConfiguration.class,
        MessageSourceConfiguration.class,
        RedisConfiguration.class
})
public class TeamsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamsServiceApplication.class, args);
    }

    @Autowired
    public void registerCreateTeamCommandInterceptor(ApplicationContext context,
                                                     CommandBus commandBus) {
        commandBus.registerDispatchInterceptor(context.getBean(CreateTeamCommandInterceptor.class));

    }

    @Autowired
    public void configure(EventProcessingConfigurer config) {
        config.registerListenerInvocationErrorHandler("team-group",
                conf -> new TeamsServiceEventsErrorHandler());

//		config.registerListenerInvocationErrorHandler("product-group",
//				conf -> PropagatingErrorHandler.instance());
    }
}
