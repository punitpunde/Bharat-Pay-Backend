package com.payments.v1.bharatPayments.dto.history;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TransactionHistoryResponse {
    private String date;
    private String time;
    private String paymentReason;
    private String receiverUpiId;
    private String mobileNumber;
    private String status;
    private Long id;
    private double amountTransferred;
    private String receiverName;
}
