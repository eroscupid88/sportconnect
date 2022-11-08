package com.sportconnect.teamsservice;

import com.sportconnect.teamsservice.core.data.TeamEntity;
import com.sportconnect.teamsservice.core.data.TeamsRepository;
import com.sportconnect.teamserviceapi.controller.model.query.FindTeamsQueryRequest;
import com.sportconnect.teamserviceapi.controller.model.query.TeamsQueryResponse;
import org.axonframework.queryhandling.QueryHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// TeamsQueryHandler invoke QueryHandler after query gateway has sent query
@Component
public class TeamsQueryHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(TeamsQueryHandler.class);
    private final TeamsRepository teamsRepository;

    public TeamsQueryHandler(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }

    /**
     * findTeams invoke after query gateway sent query from TeamsQueryController
     * @param query FindTeamsQuery all teams
     * @return List of TeamsRestModel response
     */
    @QueryHandler
    public List<TeamsQueryResponse> findTeams(FindTeamsQueryRequest query) {
        LOGGER.info("[*TeamsQueryHandler*] -> ");
        List<TeamsQueryResponse> responseTeamsRest = new ArrayList<>();
        List<TeamEntity> allTeams = teamsRepository.findAll();
        for (TeamEntity each : allTeams) {
            TeamsQueryResponse team = new TeamsQueryResponse();
            BeanUtils.copyProperties(each,team);
            responseTeamsRest.add(team);
        }
        return responseTeamsRest;
    }
}
