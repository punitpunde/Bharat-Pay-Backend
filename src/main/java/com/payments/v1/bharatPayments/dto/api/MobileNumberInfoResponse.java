package com.payments.v1.bharatPayments.dto.api;

import com.payments.v1.bharatPayments.utilities.Country;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MobileNumberInfoResponse {
    private String phone;
    private boolean valid;
    private Country country;
    private String location;
    private String type;
    private String carrier;
}
