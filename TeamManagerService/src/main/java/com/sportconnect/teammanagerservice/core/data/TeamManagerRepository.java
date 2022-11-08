package com.sportconnect.teammanagerservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamManagerRepository extends JpaRepository<TeamManagerEntity,String> {
    TeamManagerEntity findTeamManagerEntityByManagerId(String managerId);

}
