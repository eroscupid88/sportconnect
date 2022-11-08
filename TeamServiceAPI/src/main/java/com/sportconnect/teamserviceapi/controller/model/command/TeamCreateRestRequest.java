package com.sportconnect.teamserviceapi.controller.model.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TeamCreateRestRequest {
    @NotBlank(message = "userId is a required field")
    private String userId;
    @NotBlank(message = "team name is a required field")
    private String teamName;
    @NotBlank(message = "team addressId is a required field")
    private String addressId;
}
