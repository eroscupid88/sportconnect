package com.sportconnect.teamsservice;

import com.sportconnect.teamsservice.command.commands.CreateTeamCommand;
import com.sportconnect.teamsservice.core.events.TeamCreatedEvent;
import com.sportconnect.teamsservice.core.model.TeamStatus;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class TeamAggregate {

    @AggregateIdentifier
    private String teamId;
    private String userId;
    private String teamName;
    private String addressId;
    private TeamStatus teamStatus;

    // empty constructor
    protected TeamAggregate() {
    }

    @CommandHandler
    public TeamAggregate(CreateTeamCommand createTeamCommand) {
        TeamCreatedEvent teamCreatedEvent = new TeamCreatedEvent();
        BeanUtils.copyProperties(createTeamCommand, teamCreatedEvent);
        apply(teamCreatedEvent);
    }

    @EventSourcingHandler
    public void on(TeamCreatedEvent teamCreatedEvent) {
        this.teamId = teamCreatedEvent.getTeamId();
        this.userId = teamCreatedEvent.getUserId();
        this.teamName =teamCreatedEvent.getTeamName();
        this.addressId = teamCreatedEvent.getAddressId();
        this.teamStatus = teamCreatedEvent.getTeamStatus();
    }

}
