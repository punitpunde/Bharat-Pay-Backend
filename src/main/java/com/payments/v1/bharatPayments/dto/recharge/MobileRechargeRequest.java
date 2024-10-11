package com.payments.v1.bharatPayments.dto.recharge;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MobileRechargeRequest {
   private String mobileNumber;
   private String operator;
   private String circle;
   private int amount;
   private String benefit;
   private String category;
   private  String validity;
}
