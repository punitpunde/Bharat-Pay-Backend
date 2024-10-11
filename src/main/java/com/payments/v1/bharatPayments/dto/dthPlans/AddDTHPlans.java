package com.payments.v1.bharatPayments.dto.dthPlans;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddDTHPlans {
    private List<DTHPlan> dthPlans;
}
