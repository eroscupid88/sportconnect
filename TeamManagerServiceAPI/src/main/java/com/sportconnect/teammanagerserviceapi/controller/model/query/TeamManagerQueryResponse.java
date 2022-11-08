package com.sportconnect.teammanagerserviceapi.controller.model.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamManagerQueryResponse {
    private String teamManagerId;
    private String managerId;
}
