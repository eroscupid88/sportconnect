package com.sportconnect.core.model.valueobjects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileDetails {
    private int age;
    private String gender;

    // need more about profile of an athletic
}
