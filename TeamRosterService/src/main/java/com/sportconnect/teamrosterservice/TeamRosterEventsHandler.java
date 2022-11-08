package com.sportconnect.teamrosterservice;

import com.sportconnect.teamrosterservice.core.data.TeamRosterEntity;
import com.sportconnect.teamrosterservice.core.data.TeamRosterRepository;
import com.sportconnect.core.events.TeamRosterCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("roster-group")
public class TeamRosterEventsHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(TeamRosterEventsHandler.class);
    private final TeamRosterRepository teamRosterRepository;

    public TeamRosterEventsHandler(TeamRosterRepository teamRosterRepository) {
        this.teamRosterRepository = teamRosterRepository;
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
    public void on(TeamRosterCreatedEvent teamRosterCreatedEvent) {
        LOGGER.info("[*TeamRosterEventsHandler*] -> teamRosterCreatedEvent is called");
        TeamRosterEntity teamRosterEntity = new TeamRosterEntity(
                teamRosterCreatedEvent.getTeamRosterId(),
                teamRosterCreatedEvent.getTeamId(),
                teamRosterCreatedEvent.getUserId());
        try {
            teamRosterRepository.save(teamRosterEntity);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }


    }
}
