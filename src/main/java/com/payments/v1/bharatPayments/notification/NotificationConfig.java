package com.payments.v1.bharatPayments.notification;

import com.payments.v1.bharatPayments.constants.TwilioCredentials;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationConfig {

    public void sendSMS(String messageBody) {
        PhoneNumber recipientNumber = new com.twilio.type.PhoneNumber("+919424416915");
        PhoneNumber twilioNumber = new com.twilio.type.PhoneNumber(TwilioCredentials.TWILIO_PHONE_NUMBER);

        try {
            Message message = Message.creator(recipientNumber, twilioNumber, messageBody).create();

            if (message.getStatus() == Message.Status.SENT) {
                log.info("SMS sent successfully!");
            } else {
                log.error("Failed to send SMS: " + message.getErrorMessage());
            }
        } catch (Exception e) {
            log.error("An error occurred while sending SMS: " + e.getMessage(), e);
        }
    }
}