package com.payments.v1.bharatPayments.controllers;

import com.payments.v1.bharatPayments.dto.recharge.MobileRechargeRequest;
import com.payments.v1.bharatPayments.dto.recharge.MobileRechargeResponse;
import com.payments.v1.bharatPayments.dto.api.MobileNumberInfoResponse;
import com.payments.v1.bharatPayments.entities.MobileRechargePlanEntity;
import com.payments.v1.bharatPayments.services.mobileRecharge.MobileRechargeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/recharge")
public class RechargeController {

    @Autowired
    private MobileRechargeServiceImpl mobileRechargeService;

    @GetMapping("/recharge-plans/{circle_code}/{operator_code}")
    public ResponseEntity<List<MobileRechargePlanEntity>> getAllRechargePlans(@PathVariable("circle_code")String circleCode,
                                                                                 @PathVariable("operator_code")String operatorCode) {
        log.info("Request arrived for getting recharge plans");
        List<MobileRechargePlanEntity> mobileRechargePlans = mobileRechargeService.getRechargePlans(circleCode,operatorCode);
        log.info("returning the response");
        return new ResponseEntity<List<MobileRechargePlanEntity>>(mobileRechargePlans, HttpStatus.ACCEPTED);
    }

    @GetMapping("/recharge-plans/mobile-number-info/{mobile_number}")
    public ResponseEntity<MobileNumberInfoResponse> getMobileNumberInfo(@PathVariable("mobile_number")String mobileNumber) {
        log.info("Request arrived for getting mobile number info");
        MobileNumberInfoResponse mobileNumberInfoResponse = mobileRechargeService.getMobileNumberInfo(mobileNumber);
        log.info("returning the response");
        return new ResponseEntity<MobileNumberInfoResponse>(mobileNumberInfoResponse, HttpStatus.ACCEPTED);
    }

    @PostMapping ("/make-recharge")
    public ResponseEntity<MobileRechargeResponse> makeRecharge(@RequestBody MobileRechargeRequest mobileRechargeRequest) {
        log.info("Request recived for recharge");
        System.out.println(mobileRechargeRequest);
        MobileRechargeResponse mobileRechargeResponse = mobileRechargeService.makeRecharge(mobileRechargeRequest);
        log.info("returning the response");
        return new ResponseEntity<MobileRechargeResponse>(mobileRechargeResponse, HttpStatus.ACCEPTED);
    }

    @PutMapping("/save-recharge-plans")
    public void addRechargePlans(@RequestBody List<MobileRechargePlanEntity>mobileRechargePlanEntities){
        mobileRechargeService.addRechargePlans(mobileRechargePlanEntities);
    }
}
