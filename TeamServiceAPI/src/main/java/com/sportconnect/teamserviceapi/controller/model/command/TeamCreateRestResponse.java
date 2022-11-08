package com.sportconnect.teamserviceapi.controller.model.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamCreateRestResponse {
    private String teamId;
    public static TeamCreateRestResponse newBuilder() {
        return new TeamCreateRestResponse();
    }
    public TeamCreateRestResponse build() {
        return this;
    }

}
