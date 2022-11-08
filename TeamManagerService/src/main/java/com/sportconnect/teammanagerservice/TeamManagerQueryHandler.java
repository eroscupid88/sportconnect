package com.sportconnect.teammanagerservice;

import com.sportconnect.teammanagerservice.core.data.TeamManagerEntity;
import com.sportconnect.teammanagerservice.core.data.TeamManagerRepository;
import com.sportconnect.teammanagerserviceapi.controller.model.query.FindTeamManagerQueryRequest;
import com.sportconnect.teammanagerserviceapi.controller.model.query.TeamManagerQueryResponse;
import org.axonframework.queryhandling.QueryHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TeamManagerQueryHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(TeamManagerQueryHandler.class);
    private final TeamManagerRepository teamManagerRepository;

    public TeamManagerQueryHandler(TeamManagerRepository teamManagerRepository) {
        this.teamManagerRepository = teamManagerRepository;
    }

    @QueryHandler
    public TeamManagerQueryResponse getTeamManagerById(FindTeamManagerQueryRequest query) {
        LOGGER.info("[*TeamManagerQueryHandler*] -> get team manager object by id ");
        TeamManagerEntity teamManagerEntity = teamManagerRepository.findTeamManagerEntityByManagerId(query.getManagerId());
        return new TeamManagerQueryResponse(teamManagerEntity.getTeamManagerId(),teamManagerEntity.getManagerId());
    }
}
