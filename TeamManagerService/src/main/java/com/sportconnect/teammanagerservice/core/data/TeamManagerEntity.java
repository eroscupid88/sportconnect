package com.sportconnect.teammanagerservice.core.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.common.aliasing.qual.Unique;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name="teamanager")
@AllArgsConstructor
@NoArgsConstructor
public class TeamManagerEntity implements Serializable {
    private static final long serialVersionUID = -6390887724261256338L;
    @Id
    @Column(unique = true)
    private String teamManagerId;
    @Column(unique = true)
    private String managerId;

}
