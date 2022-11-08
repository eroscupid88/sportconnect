package com.sportconnect.teammanagerservice.query.rest;

import com.sportconnect.teammanagerserviceapi.controller.model.query.FindTeamManagerQueryRequest;
import com.sportconnect.teammanagerserviceapi.controller.model.query.TeamManagerQueryResponse;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/v1/teammanager")
public class TeamManagerQueryController {
    private final QueryGateway queryGateway;

    @Autowired
    public TeamManagerQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping(path = "/{managerId}")
    public CompletableFuture<TeamManagerQueryResponse> getTeamManagerById(@PathVariable("managerId") String managerId) {
        FindTeamManagerQueryRequest findTeamManagerQuery = new FindTeamManagerQueryRequest(managerId);
        return queryGateway.query(findTeamManagerQuery, ResponseTypes.instanceOf(TeamManagerQueryResponse.class));
    }
}
