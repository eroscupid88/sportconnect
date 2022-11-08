package com.sportconnect.teamsservice.command.rest;

import com.sportconnect.teamserviceapi.controller.model.command.TeamCreateRestRequest;
import com.sportconnect.teamserviceapi.controller.model.command.TeamCreateRestResponse;
import com.sportconnect.teamsservice.command.commands.CreateTeamCommand;
import com.sportconnect.teamsservice.core.model.TeamStatus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;
import java.util.UUID;

@RestController
@RequestMapping("/v1/teams")
public class TeamCommandController {
    private final CommandGateway commandGateway;

    @Autowired
    public TeamCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }


    @PostMapping
    public TeamCreateRestResponse createTeam(@RequestBody @Valid TeamCreateRestRequest teamCreateRestRequest,
                                             @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        String userId = "27b95829-4f3f-4ddf-8983-151ba010e35b";
        String teamId = UUID.randomUUID().toString();

        CreateTeamCommand createTeamCommand = CreateTeamCommand.builder()
                .teamId(teamId)
                .userId(teamCreateRestRequest.getUserId())
                .teamName(teamCreateRestRequest.getTeamName())
                .addressId(teamCreateRestRequest.getAddressId())
                .teamStatus(TeamStatus.CREATED)
                .build();
        String value;
        value = commandGateway.sendAndWait(createTeamCommand);
        return new TeamCreateRestResponse(value);
    }
}
