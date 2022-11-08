package com.sportconnect.userservice;

import com.sportconnect.core.model.valueobjects.PaymentDetails;
import com.sportconnect.core.model.valueobjects.ProfileDetails;
import com.sportconnect.core.model.valueobjects.User;
import com.sportconnect.core.query.FetchUserPaymentDetailsQuery;
import com.sportconnect.core.query.FetchUserProfileDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserQueryEventHandler {
    private final String FIRSTNAME = "Dillon";
    private final String LASTNAME = "Vu";

    @QueryHandler
    public User findUserPaymentDetails(FetchUserPaymentDetailsQuery query) {

        PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("123Card")
                .cvv("123")
                .name("Dillon Vu")
                .validUntilMonth(12)
                .validUntilYear(2030)
                .build();

        return User.builder()
                .firstName(FIRSTNAME)
                .lastName(LASTNAME)
                .userId(query.getUserId())
                .paymentDetails(paymentDetails)
                .build();

    }

    @QueryHandler
    public User findUserProfileDetails(FetchUserProfileDetailsQuery query) {
        ProfileDetails profileDetails = ProfileDetails.builder()
                .age(20)
                .gender("male")
                .build();
        return User.builder()
                .firstName(FIRSTNAME)
                .lastName(LASTNAME)
                .userId(query.getUserId())
                .profileDetails(profileDetails)
                .build();
    }

}
