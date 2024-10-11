package com.payments.v1.bharatPayments.services.mobileRecharge;


import com.payments.v1.bharatPayments.dto.recharge.MobileRechargeRequest;
import com.payments.v1.bharatPayments.dto.recharge.MobileRechargeResponse;
import com.payments.v1.bharatPayments.dto.api.MobileNumberInfoResponse;
import com.payments.v1.bharatPayments.entities.MobileRechargePlanEntity;

import java.util.List;

public interface MobileRechargeService {

    List<MobileRechargePlanEntity> getRechargePlans(String circleCode, String operatorCode);

    MobileNumberInfoResponse getMobileNumberInfo(String mobileNumber);

    MobileRechargeResponse makeRecharge(MobileRechargeRequest mobileRechargeRequest);

    void addRechargePlans(List<MobileRechargePlanEntity> mobileRechargePlans);
}
