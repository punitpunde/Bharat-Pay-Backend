package com.payments.v1.bharatPayments.dto.moneyTransfer;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MoneyTransferRequest {
     private String receiverUpiId;

     private double amountTransferred;

     private String transactionId;
     private String transactionDate;
     private String paymentReason;
     private String senderUpiId;
     private String senderPassword;
}
