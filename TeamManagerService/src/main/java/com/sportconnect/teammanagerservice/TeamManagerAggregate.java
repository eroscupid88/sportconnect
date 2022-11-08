package com.sportconnect.teammanagerservice;

import com.sportconnect.core.commands.CreateTeamManagerCommand;
import com.sportconnect.core.events.TeamManagerCreatedEvent;
import com.sportconnect.teammanagerservice.core.TeamManagerStatus;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class TeamManagerAggregate {
    @AggregateIdentifier
    private String teamManagerId;
    private String managerId;
    private TeamManagerStatus teamManagerStatus;

    /**
     * Empty Constructor
     */
    protected TeamManagerAggregate() {
    }

    @CommandHandler
    public TeamManagerAggregate(CreateTeamManagerCommand createTeamManagerCommand) {
        TeamManagerCreatedEvent teamManagerCreatedEvent = TeamManagerCreatedEvent.builder()
                .teamManagerId(createTeamManagerCommand.getTeamManagerId())
                .managerId(createTeamManagerCommand.getManagerId())
                .build();
        apply(teamManagerCreatedEvent);
    }

    @EventSourcingHandler
    public void on(TeamManagerCreatedEvent teamManagerCreatedEvent) {
        teamManagerId = teamManagerCreatedEvent.getTeamManagerId();
        managerId = teamManagerCreatedEvent.getManagerId();
        teamManagerStatus = TeamManagerStatus.CREATED;
    }
}
