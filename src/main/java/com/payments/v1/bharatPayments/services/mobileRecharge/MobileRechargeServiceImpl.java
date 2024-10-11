package com.payments.v1.bharatPayments.services.mobileRecharge;

import com.payments.v1.bharatPayments.constants.AbstractApiCredentials;
import com.payments.v1.bharatPayments.constants.AppMessageConstants;
import com.payments.v1.bharatPayments.constants.TwilioCredentials;
import com.payments.v1.bharatPayments.dto.recharge.MobileRechargeRequest;
import com.payments.v1.bharatPayments.dto.recharge.MobileRechargeResponse;
import com.payments.v1.bharatPayments.dto.api.MobileNumberInfoResponse;
import com.payments.v1.bharatPayments.entities.MobileRechargeEntity;
import com.payments.v1.bharatPayments.entities.MobileRechargePlanEntity;
import com.payments.v1.bharatPayments.notification.NotificationsUtility;
import com.payments.v1.bharatPayments.repositories.MobileRechargeRepository;
import com.payments.v1.bharatPayments.repositories.RechargePlansRepository;
import com.payments.v1.bharatPayments.utilities.RechargePlan;
import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Component
public class MobileRechargeServiceImpl implements MobileRechargeService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MobileRechargeRepository mobileRechargeRepository;

    @Autowired
    private RechargePlansRepository rechargePlansRepository;

    @Autowired
    NotificationsUtility notificationsUtility;

    static {
        Twilio.init(TwilioCredentials.TWILIO_ACCOUNT_SID, TwilioCredentials.TWILIO_AUTH_TOKEN);
    }


    public List<MobileRechargePlanEntity> getRechargePlans(String circleCode, String operatorCode) {

//        String apiUrl = RapidApiCredentials.API_URL;
//        apiUrl = apiUrl.replace("registered_email_id", RapidApiCredentials.EMAIL_ID)
//                .replace("apikey", RapidApiCredentials.API_KEY)
//                .replace("Circle_Code", circleCode)
//                .replace("Operator_code", operatorCode);
//
//        ResponseEntity<MobileRechargePlansApiResponse> response = restTemplate.exchange(
//                apiUrl, HttpMethod.GET, null, MobileRechargePlansApiResponse.class);
//
//        MobileRechargePlansApiResponse mobileRechargeResponses = response.getBody();
//        return mobileRechargeResponses.getData();
        return rechargePlansRepository.findAll();
    }


    public MobileNumberInfoResponse getMobileNumberInfo(String mobileNumber) {
        String apiUrl = AbstractApiCredentials.API_URL;
        apiUrl = apiUrl.replace("APIKEY", AbstractApiCredentials.API_KEY)
                .replace("MOBILE", mobileNumber);

        System.out.println(apiUrl);
        ResponseEntity<MobileNumberInfoResponse> response = restTemplate.exchange(
                apiUrl, HttpMethod.GET, null, MobileNumberInfoResponse.class);

        return response.getBody();
    }

    public MobileRechargeResponse makeRecharge(MobileRechargeRequest mobileRechargeRequest) {
        MobileRechargeEntity mobileRecharge = MobileRechargeEntity.builder()
                .date(new Date())
                .benefit(mobileRechargeRequest.getBenefit())
                .category(mobileRechargeRequest.getCategory())
                .amount(mobileRechargeRequest.getAmount())
                .validity(mobileRechargeRequest.getValidity())
                .verdict("Recharge Done")
                .mobileNumber(mobileRechargeRequest.getMobileNumber())
                .circle(mobileRechargeRequest.getCircle())
                .operator(mobileRechargeRequest.getOperator())
                .build();
        RechargePlan rechargePlan = RechargePlan.builder()
                .category(mobileRechargeRequest.getCategory())
                .amount(mobileRechargeRequest.getAmount())
                .benefit(mobileRechargeRequest.getBenefit()).build();
        mobileRechargeRepository.save(mobileRecharge);
//        notificationsUtility.sendForRechargeSuccessInfo(rechargePlan, mobileRechargeRequest.getMobileNumber());
        return MobileRechargeResponse.builder().message(AppMessageConstants.MOBILE_RECHARGE_SUCCESS).build();
    }

    public void addRechargePlans(List<MobileRechargePlanEntity> mobileRechargePlans) {
        for (MobileRechargePlanEntity mobileRechargePlanEntity : mobileRechargePlans) {
            rechargePlansRepository.save(mobileRechargePlanEntity);
        }
    }
}
