package com.payments.v1.bharatPayments.services.dthPlan;

import com.payments.v1.bharatPayments.constants.AppMessageConstants;
import com.payments.v1.bharatPayments.dto.dthPlans.AddDTHPlans;
import com.payments.v1.bharatPayments.entities.DTHPlansEntity;
import com.payments.v1.bharatPayments.repositories.DTHPlansRepository;
import com.payments.v1.bharatPayments.dto.dthPlans.DTHPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DTHPlansServiceImpl {
    @Autowired
    private DTHPlansRepository dthPlansRepository;

    public String addDTHPlans(AddDTHPlans addDTHPlans) {
        List<DTHPlan> dthPlans = addDTHPlans.getDthPlans();
        for (DTHPlan dthPlan : dthPlans) {
            DTHPlansEntity dthPlansEntity = DTHPlansEntity.builder()
                    .planId(dthPlan.getPlanId())
                    .planName(dthPlan.getPlanName())
                    .amount(dthPlan.getAmount())
                    .operator(dthPlan.getOperator())
                    .validityDays(dthPlan.getValidityDays())
                    .channels((dthPlan.getChannels()))
                    .build();

            dthPlansRepository.save(dthPlansEntity);

        }
        return AppMessageConstants.DTH_PLANS_ADDED;
    }

    public List<DTHPlan> getDTHPlans() {
        List<DTHPlan> dthPlansResponses = new ArrayList<>();
        List<DTHPlansEntity> dthPlansEntities = dthPlansRepository.findAll();

        for (DTHPlansEntity dthPlansEntity : dthPlansEntities) {
            DTHPlan dthPlan = DTHPlan.builder()
                    .planId(dthPlansEntity.getPlanId())
                    .planName(dthPlansEntity.getPlanName())
                    .amount(dthPlansEntity.getAmount())
                    .validityDays(dthPlansEntity.getValidityDays())
                    .channels(dthPlansEntity.getChannels())
                    .operator(dthPlansEntity.getOperator())
                    .build();

            dthPlansResponses.add(dthPlan);
        }

        return dthPlansResponses;
    }

}
