package com.payments.v1.bharatPayments.controllers;

import com.payments.v1.bharatPayments.dto.dthPlans.AddDTHPlans;
import com.payments.v1.bharatPayments.dto.dthPlans.DTHPlan;
import com.payments.v1.bharatPayments.services.dthPlan.DTHPlansServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dth")
public class DTHController {

    @Autowired
    private DTHPlansServiceImpl dthPlansService;

    @PutMapping("/add-dth-plans")
    public ResponseEntity<String> addDTHPlans(@RequestBody AddDTHPlans addDTHPlans) {
        String message = dthPlansService.addDTHPlans(addDTHPlans);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-dth-plans")
    public ResponseEntity<List<DTHPlan>> getDTHPlans() {
        List<DTHPlan> dthPlans = dthPlansService.getDTHPlans();
        return new ResponseEntity<>(dthPlans, HttpStatus.OK);
    }
}
