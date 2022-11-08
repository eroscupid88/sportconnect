package com.sportconnect.teammanagerserviceapi.controller.model.query;

import lombok.Value;

@Value
public class FindTeamManagerQueryRequest {
    private String managerId;

    public FindTeamManagerQueryRequest(String managerId) {
        this.managerId = managerId;
    }
}
