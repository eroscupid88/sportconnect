package com.sportconnect.teamsservice;

import com.sportconnect.core.commands.CreateTeamManagerCommand;
import com.sportconnect.core.commands.CreateTeamRosterCommand;
import com.sportconnect.core.events.TeamManagerCreatedEvent;
import com.sportconnect.core.events.TeamRosterCreatedEvent;
import com.sportconnect.teamsservice.core.events.TeamCreatedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Saga
public class TeamSaga {
    private static final Logger LOGGER = LoggerFactory.getLogger(TeamSaga.class);
    @Autowired
    private transient CommandGateway commandGateway;

    private Boolean teamRosterCreated = false;
    private Boolean teamManagerCreated = false;
    private Boolean teamBankCreated = false;

    @StartSaga
    @SagaEventHandler(associationProperty = "teamId")
    public void handler(TeamCreatedEvent teamCreatedEvent) {
        LOGGER.info("[TeamSaga] -> teamCreateEvent was called" );
        String teamRosterId = UUID.randomUUID().toString();
        String teamManagerId = UUID.randomUUID().toString();
        SagaLifecycle.associateWith("teamRosterId", teamRosterId);
        SagaLifecycle.associateWith("teamManagerId", teamManagerId);
        CreateTeamRosterCommand createTeamRosterCommand = CreateTeamRosterCommand.builder()
                .teamRosterId(teamRosterId)
                .teamId(teamCreatedEvent.getTeamId())
                .userId(teamCreatedEvent.getUserId())
                .build();
        CreateTeamManagerCommand createTeamManagerCommand = CreateTeamManagerCommand.builder()
                .teamManagerId(teamManagerId)
                .managerId(teamCreatedEvent.getUserId())
                .build();
        commandGateway.send(createTeamRosterCommand);
        commandGateway.send(createTeamManagerCommand);
    }

    @SagaEventHandler(associationProperty = "teamRosterId")
    public void handler(TeamRosterCreatedEvent teamRosterCreatedEvent) {
        LOGGER.info("[TeamSaga] -> teamRosterCreatedEvent was called" );
        teamRosterCreated = true;
        SagaLifecycle.end();
    }

    @SagaEventHandler(associationProperty = "teamManagerId")
    public void handler(TeamManagerCreatedEvent teamManagerCreatedEvent) {
        LOGGER.info("[TeamSaga] -> teamManagerCreatedEvent was called" );
        teamManagerCreated =true;
        SagaLifecycle.end();
    }
}
