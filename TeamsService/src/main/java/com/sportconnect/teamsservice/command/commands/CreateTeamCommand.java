package com.sportconnect.teamsservice.command.commands;

import com.sportconnect.teamsservice.core.model.TeamStatus;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class CreateTeamCommand {

    @TargetAggregateIdentifier
    private final String teamId;
    private final String userId;
    private final String teamName;
    private final String addressId;
    private TeamStatus teamStatus;

}
