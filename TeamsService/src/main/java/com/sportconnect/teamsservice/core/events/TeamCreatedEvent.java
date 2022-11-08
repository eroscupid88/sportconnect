package com.sportconnect.teamsservice.core.events;

import com.sportconnect.teamsservice.core.model.TeamStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamCreatedEvent {

    private String teamId;
    private String userId;
    private String teamName;
    private String addressId;
    private TeamStatus teamStatus;

}
