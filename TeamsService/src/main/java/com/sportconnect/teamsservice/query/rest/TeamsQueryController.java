package com.sportconnect.teamsservice.query.rest;

import com.sportconnect.teamserviceapi.controller.model.query.FindTeamsQueryRequest;
import com.sportconnect.teamserviceapi.controller.model.query.TeamsQueryResponse;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/teams")
public class TeamsQueryController {

    private final QueryGateway queryGateway;

    @Autowired
    public TeamsQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    /**
     * function get method getTeams to return all team objects
     * @return a list of TeamsRestModel object
     */
    @GetMapping
    public List<TeamsQueryResponse> getTeams() {
        FindTeamsQueryRequest findTeamsQuery = new FindTeamsQueryRequest();
        return queryGateway.query(findTeamsQuery, ResponseTypes.multipleInstancesOf(TeamsQueryResponse.class)).join();
    }
}
