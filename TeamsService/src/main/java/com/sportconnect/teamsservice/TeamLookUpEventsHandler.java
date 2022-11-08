package com.sportconnect.teamsservice;

import com.sportconnect.teamsservice.core.data.TeamLookUpEntity;
import com.sportconnect.teamsservice.core.data.TeamsLookUpRepository;
import com.sportconnect.teamsservice.core.events.TeamCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("team-group")
public class TeamLookUpEventsHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(TeamLookUpEventsHandler.class);
    private final TeamsLookUpRepository teamsLookUpRepository;

    public TeamLookUpEventsHandler(TeamsLookUpRepository teamsLookUpRepository) {
        this.teamsLookUpRepository = teamsLookUpRepository;
    }


    @EventHandler
    public void on(TeamCreatedEvent teamCreatedEvent) {
        LOGGER.info("[*TeamLookUpEventsHandler*]: teamCreatedEvent was called");
        TeamLookUpEntity teamLookUpEntity = new TeamLookUpEntity(teamCreatedEvent.getTeamId(),teamCreatedEvent.getUserId() ,teamCreatedEvent.getTeamName() );
        teamsLookUpRepository.save(teamLookUpEntity);
    }
}
