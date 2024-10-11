package com.payments.v1.bharatPayments.utilities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class RechargePlan {
    private int amount;
    private String benefit;
    private String category;
}
