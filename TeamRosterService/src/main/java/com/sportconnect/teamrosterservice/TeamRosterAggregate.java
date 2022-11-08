package com.sportconnect.teamrosterservice;

import com.sportconnect.core.commands.CreateTeamRosterCommand;
import com.sportconnect.core.events.TeamRosterCreatedEvent;
import com.sportconnect.teamrosterservice.core.model.TeamRosterStatus;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class TeamRosterAggregate {
    @AggregateIdentifier
    private String teamRosterId;
    private String teamId;
    private String userId;
    private TeamRosterStatus teamRosterStatus;





    // empty constructor
    protected TeamRosterAggregate() {
    }

    @CommandHandler
    public TeamRosterAggregate(CreateTeamRosterCommand createTeamRosterCommand) {
        TeamRosterCreatedEvent teamRosterCreatedEvent = TeamRosterCreatedEvent.builder()
                .teamRosterId(createTeamRosterCommand.getTeamRosterId())
                .teamId(createTeamRosterCommand.getTeamId())
                .userId(createTeamRosterCommand.getUserId())
                .build();
        apply(teamRosterCreatedEvent);

    }

    @EventSourcingHandler
    public void on(TeamRosterCreatedEvent teamRosterCreatedEvent) {
        teamRosterId = teamRosterCreatedEvent.getTeamRosterId();
        teamId = teamRosterCreatedEvent.getTeamId();
        userId= teamRosterCreatedEvent.getUserId();
        teamRosterStatus = TeamRosterStatus.CREATED;
    }

}
