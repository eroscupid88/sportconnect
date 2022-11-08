package com.sportconnect.teamsservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamsRepository extends JpaRepository<TeamEntity,String> {
    TeamEntity findByTeamIdOrTeamNameOrUserId(String teamId, String teamName,String UserId);
}
