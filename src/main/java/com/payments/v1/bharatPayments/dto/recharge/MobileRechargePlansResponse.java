package com.payments.v1.bharatPayments.dto.recharge;

import lombok.Data;

@Data
public class MobileRechargePlansResponse {
        public int amount;
        public String validity;
        public String benefit;
        public String category;
}
