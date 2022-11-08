package com.sportconnect.teammanagerservice;

import com.sportconnect.core.events.TeamManagerCreatedEvent;
import com.sportconnect.teammanagerservice.core.data.TeamManagerEntity;
import com.sportconnect.teammanagerservice.core.data.TeamManagerRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("manager-group")
public class TeamManagerEventsHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(TeamManagerEventsHandler.class);
    private final TeamManagerRepository teamManagerRepository;

    public TeamManagerEventsHandler(TeamManagerRepository teamManagerRepository) {
        this.teamManagerRepository = teamManagerRepository;
    }

    @ExceptionHandler(resultType=Exception.class)
    public void handle(Exception exception) throws Exception {
        throw exception;
    }

    @ExceptionHandler(resultType=IllegalArgumentException.class)
    public void handle(IllegalArgumentException exception) {
        // Log error message
        throw exception;
    }

    @EventHandler
    public void on(TeamManagerCreatedEvent teamManagerCreatedEvent) {
        LOGGER.info("[*TeamManagerEventsHandler*] -> teamManagerCreatedEvent is called");
        TeamManagerEntity teamManagerEntity = new TeamManagerEntity(
                teamManagerCreatedEvent.getTeamManagerId(),
                teamManagerCreatedEvent.getManagerId()
        );
        try {
            teamManagerRepository.save(teamManagerEntity);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }
}
