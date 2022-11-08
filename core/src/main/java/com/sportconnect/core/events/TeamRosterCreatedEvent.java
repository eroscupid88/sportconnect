package com.sportconnect.core.events;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamRosterCreatedEvent {
    private String teamRosterId;
    private String teamId;
    private String userId;
}
