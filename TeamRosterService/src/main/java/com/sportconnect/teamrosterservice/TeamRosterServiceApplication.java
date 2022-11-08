package com.sportconnect.teamrosterservice;

import com.sportconnect.teamrosterservice.command.interceptors.CreateTeamRosterCommandInterceptor;
import com.sportconnect.teamrosterservice.config.axonconfiguration.AxonConfig;
import com.sportconnect.teamrosterservice.config.locationconfiguration.LocationConfiguration;
import com.sportconnect.teamrosterservice.config.messagesourceconfiguration.MessageSourceConfiguration;
import com.sportconnect.teamrosterservice.config.redisconfiguration.RedisConfiguration;
import com.sportconnect.teamrosterservice.core.errorhandling.TeamRosterServiceEventsErrorHandler;
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
public class TeamRosterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamRosterServiceApplication.class, args);
    }

    @Autowired
    public void registerCreateTeamRosterCommandInterceptor(ApplicationContext context,
                                                     CommandBus commandBus) {
        commandBus.registerDispatchInterceptor(context.getBean(CreateTeamRosterCommandInterceptor.class));

    }

    @Autowired
    public void configure(EventProcessingConfigurer config) {
        config.registerListenerInvocationErrorHandler("roster-group",
                conf -> new TeamRosterServiceEventsErrorHandler());

//		config.registerListenerInvocationErrorHandler("product-group",
//				conf -> PropagatingErrorHandler.instance());
    }
}
