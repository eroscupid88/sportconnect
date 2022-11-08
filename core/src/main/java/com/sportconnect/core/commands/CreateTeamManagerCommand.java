package com.sportconnect.core.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateTeamManagerCommand {
    @TargetAggregateIdentifier
    private final String teamManagerId;
    private final String managerId;
}
