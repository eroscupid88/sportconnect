package com.sportconnect.userservice.query.rest;


import com.sportconnect.core.model.valueobjects.User;
import com.sportconnect.core.query.FetchUserPaymentDetailsQuery;
import com.sportconnect.core.query.FetchUserProfileDetailsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserQueryController {
    @Autowired
    QueryGateway queryGateway;
    @GetMapping("/{userId}/payment-details")
    public User getUserPaymentDetails(@PathVariable String userId) {
        FetchUserPaymentDetailsQuery query = new FetchUserPaymentDetailsQuery(userId);
        return queryGateway.query(query, ResponseTypes.instanceOf(User.class)).join();
    }

    @GetMapping("/{userId}/user-profile-details")
    public User getUserProfileDetails(@PathVariable String userId) {
        FetchUserProfileDetailsQuery query = new FetchUserProfileDetailsQuery(userId);
        return queryGateway.query(query, ResponseTypes.instanceOf(User.class)).join();
    }
}
