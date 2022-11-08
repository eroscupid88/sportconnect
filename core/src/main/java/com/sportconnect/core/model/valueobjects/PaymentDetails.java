package com.sportconnect.core.model.valueobjects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentDetails {

    // mastercard info
    private String name;
    private String cardNumber;
    private int validUntilMonth;
    private int validUntilYear;
    private String cvv;
    
}
