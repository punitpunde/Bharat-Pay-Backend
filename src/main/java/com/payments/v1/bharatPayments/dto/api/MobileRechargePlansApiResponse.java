package com.payments.v1.bharatPayments.dto.api;

import com.payments.v1.bharatPayments.dto.recharge.MobileRechargePlansResponse;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
@Getter
@Setter
@ToString
public class MobileRechargePlansApiResponse {
        private List<Object> status;
        private List<MobileRechargePlansResponse> data;
}
