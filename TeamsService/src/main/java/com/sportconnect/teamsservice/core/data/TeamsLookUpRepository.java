package com.sportconnect.teamsservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TeamsLookUpRepository extends JpaRepository<TeamLookUpEntity, String> {
    TeamLookUpEntity findByTeamIdOrUserIdOrTeamName(String teamId, String userId ,String teamName);
}
