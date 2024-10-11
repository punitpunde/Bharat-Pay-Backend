package com.payments.v1.bharatPayments.notification;

import com.payments.v1.bharatPayments.utilities.RechargePlan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationsUtility {
    NotificationConfig notificationConfig = new NotificationConfig();

    public void sendForRechargeSuccessInfo(RechargePlan rechargePlan,String mobileNumber){
        String message = "Recharge for mobile number "+mobileNumber+" is done. Your Packs and benefits are listed below \n"+ rechargePlan;
        notificationConfig.sendSMS(message);
    }
}
