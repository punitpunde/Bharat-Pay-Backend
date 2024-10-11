package com.payments.v1.bharatPayments.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "MONEY_TRANSFER")
public class MoneyTransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String receiverUpiId;       // UPI ID of the business (if applicable)
    private String receiverMobileNumber;
    private String status;
    // Transaction Details


    private double amountTransferred;    // Amount of money transferred
    private String paymentReason;          // Type of payment (e.g., UPI, net banking)
    private String transactionId;        // Unique transaction identifier
    private Date transactionDate;      // Date and time of the transaction

    // Sender Information
    private String senderUpiId;          // UPI ID of the sender (if applicable)
}
