package com.sportconnect.teammanagerservice;

import com.sportconnect.teammanagerservice.command.interceptors.CreateTeamManagerCommandInterceptor;
import com.sportconnect.teammanagerservice.config.axonconfiguration.AxonConfig;
import com.sportconnect.teammanagerservice.config.locationconfiguration.LocationConfiguration;
import com.sportconnect.teammanagerservice.config.messagesourceconfiguration.MessageSourceConfiguration;
import com.sportconnect.teammanagerservice.config.redisconfiguration.RedisConfiguration;
import com.sportconnect.teammanagerservice.core.errorhandling.TeamManagerServiceEventsErrorHandler;
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
public class TeamManagerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamManagerServiceApplication.class, args);
    }

    @Autowired
    public void registerCreateTeamManagerCommandInterceptor(ApplicationContext context,
                                                     CommandBus commandBus) {
        commandBus.registerDispatchInterceptor(context.getBean(CreateTeamManagerCommandInterceptor.class));

    }

    @Autowired
    public void configure(EventProcessingConfigurer config) {
        config.registerListenerInvocationErrorHandler("manager-group",
                conf -> new TeamManagerServiceEventsErrorHandler());

//		config.registerListenerInvocationErrorHandler("product-group",
//				conf -> PropagatingErrorHandler.instance());
    }
}
