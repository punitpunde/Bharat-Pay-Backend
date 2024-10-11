package com.payments.v1.bharatPayments.controllers;

import com.payments.v1.bharatPayments.dto.history.TransactionHistoryRequest;
import com.payments.v1.bharatPayments.dto.history.TransactionHistoryResponse;
import com.payments.v1.bharatPayments.dto.moneyTransfer.MoneyTransferRequest;
import com.payments.v1.bharatPayments.dto.moneyTransfer.MoneyTransferResponse;
import com.payments.v1.bharatPayments.services.moneyTransfer.MoneyTransferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/money-transfer")
public class MoneyTransferController {

    @Autowired
    private MoneyTransferService moneyTransferService;

    @PostMapping("/transfer")
    public ResponseEntity<MoneyTransferResponse> transferMoney(@RequestBody MoneyTransferRequest moneyTransferRequest) {
        log.info("Request Received to transfer money");
        MoneyTransferResponse moneyTransferResponse = moneyTransferService.moneyTransfer((moneyTransferRequest));
        log.info("Returning response for transferring the money");
        return new ResponseEntity<MoneyTransferResponse>(moneyTransferResponse, HttpStatus.ACCEPTED);
    }

    @PostMapping("/transaction-history")
    public ResponseEntity<List<TransactionHistoryResponse>> transactionHistory(@RequestBody TransactionHistoryRequest request) {
        log.info("Request Received to get transaction History");
        List<TransactionHistoryResponse> transactionHistoryResponses = moneyTransferService.getTransactionHistory(request);
        log.info("Returning response for Transaction history");
        return new ResponseEntity<List<TransactionHistoryResponse>>(transactionHistoryResponses, HttpStatus.ACCEPTED);
    }
}
