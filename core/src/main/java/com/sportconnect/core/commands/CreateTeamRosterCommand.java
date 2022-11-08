package com.sportconnect.core.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateTeamRosterCommand {

    @TargetAggregateIdentifier
    private final String teamRosterId;
    private final String teamId;
    private final String userId;

}
