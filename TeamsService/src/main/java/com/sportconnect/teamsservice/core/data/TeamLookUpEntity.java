package com.sportconnect.teamsservice.core.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="teamlookup")
public class TeamLookUpEntity implements Serializable {

    private static final long serialVersionUID = 5158270708132352769L;
    @Id
    private String teamId;
    @Column(unique=true)
    private String userId;
    @Column(unique=true)
    private String teamName;
}
