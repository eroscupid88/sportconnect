package com.sportconnect.teamsservice.core.data;

import com.sportconnect.teamsservice.core.model.TeamStatus;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="teams")
@Data
public class TeamEntity implements Serializable {


    private static final long serialVersionUID = 7351653088778587171L;
    @Id
    @Column(unique=true)
    private String teamId;
    @Column(unique=true)
    private String userId;
    @Column(unique=true)
    private String teamName;
    private String addressId;

}
