package com.payments.v1.bharatPayments.dto.dthPlans;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DTHPlan {
    private String planId;
    private String planName;
    private int amount;
    private int validityDays;
    private int channels;
    private String operator;
}
