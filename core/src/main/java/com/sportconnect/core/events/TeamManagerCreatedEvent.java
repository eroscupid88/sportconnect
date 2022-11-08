package com.sportconnect.core.events;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamManagerCreatedEvent {
    private final String teamManagerId;
    private final String managerId;
}
