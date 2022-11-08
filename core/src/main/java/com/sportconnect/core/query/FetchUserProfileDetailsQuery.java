package com.sportconnect.core.query;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FetchUserProfileDetailsQuery {
    private String userId;
}
