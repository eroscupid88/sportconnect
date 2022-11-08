package com.sportconnect.teamrosterservice.core.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name="teamroster")
@AllArgsConstructor
@NoArgsConstructor
public class TeamRosterEntity implements Serializable {

    private static final long serialVersionUID = -8629852833745221019L;
    @Id
    @Column(unique=true)
    private String teamRosterId;
    @Column(unique=true)
    private String teamId;
    private String userId;
}
