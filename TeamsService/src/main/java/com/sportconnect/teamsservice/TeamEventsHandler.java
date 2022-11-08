package com.sportconnect.teamsservice;

import com.sportconnect.teamsservice.core.data.TeamEntity;
import com.sportconnect.teamsservice.core.data.TeamsRepository;
import com.sportconnect.teamsservice.core.events.TeamCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("team-group")
public class TeamEventsHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(TeamEventsHandler.class);

    private final TeamsRepository teamsRepository;

    public TeamEventsHandler(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }

    @ExceptionHandler(resultType=Exception.class)
    public void handle(Exception exception) throws Exception {
        throw exception;
    }

    @ExceptionHandler(resultType=IllegalArgumentException.class)
    public void handle(IllegalArgumentException exception) {
        // Log error message
    }


    @EventHandler
    public void on(TeamCreatedEvent teamCreatedEvent) {
        LOGGER.info("[*TeamEventsHandler*]: teamCreatedEvent was called");
        TeamEntity teamEntity = new TeamEntity();
        BeanUtils.copyProperties(teamCreatedEvent, teamEntity);
        try {
            teamsRepository.save(teamEntity);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }
}
