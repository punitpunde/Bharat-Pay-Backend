package com.payments.v1.bharatPayments.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    public static String getFormattedTransactionDate(Date transactionDate) {

        // Define the date format with AM/PM marker
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");

        // Format the transaction date
        return dateFormat.format(transactionDate);
    }

}
