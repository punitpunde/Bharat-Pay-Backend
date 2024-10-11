package com.payments.v1.bharatPayments.services.moneyTransfer;

import com.payments.v1.bharatPayments.constants.AppMessageConstants;
import com.payments.v1.bharatPayments.dto.history.TransactionHistoryRequest;
import com.payments.v1.bharatPayments.dto.history.TransactionHistoryResponse;
import com.payments.v1.bharatPayments.dto.moneyTransfer.MoneyTransferRequest;
import com.payments.v1.bharatPayments.dto.moneyTransfer.MoneyTransferResponse;
import com.payments.v1.bharatPayments.entities.MoneyTransactionEntity;
import com.payments.v1.bharatPayments.helper.DateFormatter;
import com.payments.v1.bharatPayments.repositories.MoneyTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MoneyTransferService {
    @Autowired
    private MoneyTransferRepository moneyTransferRepository;

    public MoneyTransferResponse moneyTransfer(MoneyTransferRequest moneyTransferRequest) {
        // Create the MoneyTransferEntity with a Date object
        MoneyTransactionEntity moneyTransferEntity = MoneyTransactionEntity.builder()
                .receiverUpiId(moneyTransferRequest.getReceiverUpiId())
                .amountTransferred(moneyTransferRequest.getAmountTransferred())
                .senderUpiId(moneyTransferRequest.getSenderUpiId())
                .transactionDate(new Date()) // Store the actual Date object
                .paymentReason(moneyTransferRequest.getPaymentReason())
                .build();

        moneyTransferRepository.save(moneyTransferEntity);

        return MoneyTransferResponse.builder().message(AppMessageConstants.MONEY_TRANSFER_SUCCESS).build();
    }

    public List<TransactionHistoryResponse> getTransactionHistory(TransactionHistoryRequest transactionHistoryRequest) {

        List<MoneyTransactionEntity> moneyTransferEntities = moneyTransferRepository.findAll();
        List<TransactionHistoryResponse> transactionHistoryResponses = new ArrayList<>();
        for (MoneyTransactionEntity transaction : moneyTransferEntities) {
            String formattedTransactionDate = DateFormatter.getFormattedTransactionDate(transaction.getTransactionDate());
            String[] dateTimeParts = formattedTransactionDate.split(" ");
            String date = dateTimeParts[0];
            String time = dateTimeParts[1] + " " + dateTimeParts[2];

            TransactionHistoryResponse response = TransactionHistoryResponse.builder()
                    .amountTransferred(transaction.getAmountTransferred())
                    .id(transaction.getId())
                    .receiverUpiId(transaction.getReceiverUpiId())
                    .paymentReason(transaction.getPaymentReason())
                    .mobileNumber(transaction.getReceiverMobileNumber())
                    .status(transaction.getStatus())
                    .date(date)
                    .time(time)
                    .receiverName("")
                    .build();
            transactionHistoryResponses.add(response);
        }

        return transactionHistoryResponses;
    }

}