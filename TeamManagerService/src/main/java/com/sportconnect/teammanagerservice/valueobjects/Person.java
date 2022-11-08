package com.sportconnect.teammanagerservice.valueobjects;

import lombok.Data;

import java.util.Date;

@Data
public abstract class Person {
    private String firstName;
    private String lastName;
    private Date dob;

}
