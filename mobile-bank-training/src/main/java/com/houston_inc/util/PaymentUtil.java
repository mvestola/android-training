package com.houston_inc.util;

import com.houston_inc.android.activity.LoginActivity;
import com.houston_inc.domain.IBAN;
import com.houston_inc.domain.Payment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentUtil {

    /**
     * Converts the given bank barcode to payment details. There are multiple barcode versions available.
     * This util method can handle V4 and V5 barcodes. See more from "Pankkiviivakoodistandardi" in
     * http://www.fkl.fi/teemasivut/sepa/tekninen_dokumentaatio/Sivut/default.aspx
     *
     * @param barcode Barcode in V4 or V5 format.
     * @return
     */
    public static Payment gePaymentFromBarcode(String barcode) {

        if (barcode==null || barcode.trim().equals("") || barcode.length()<54) {
            return null;
        }

        final int versionCode = Integer.parseInt(barcode.substring(0,1));

        switch (versionCode) {
            case 5:
                return gePaymentFromBarcodeV5(barcode);
            case 4:
                return gePaymentFromBarcodeV4(barcode);
            default:
                return null;
        }

    }

    private static Payment gePaymentFromBarcodeV4(String barcode) {

        String receiver = barcode.substring(1,1+16);
        String euros = barcode.substring(1+16,1+16+6);
        String cents = barcode.substring(1+16+6,1+16+6+2);
        String ref = barcode.substring(1+16+6+2+3,1+16+6+2+3+20);
        String dueDateString = barcode.substring(1+16+6+2+23,1+16+6+2+23+6);

        ref = ref.replaceFirst("^0+(?!$)", ""); // Remove zero paddings

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date dueDate = null;
        try {
            if (!dueDateString.replaceAll("0", "").trim().equals("")) {
                dueDate = format.parse("20"+dueDateString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Payment payment = new Payment();
        payment.setReceiver(new IBAN(getCountryCode(receiver)+receiver));
        payment.setAmount(Double.valueOf(euros) + Double.valueOf(cents) / 100.0);
        payment.setReference(ref);
        payment.setDueDate(dueDate);

        return payment;

    }

    private static Payment gePaymentFromBarcodeV5(String barcode) {

        String receiver = barcode.substring(1,1+16);
        String euros = barcode.substring(1+16,1+16+6);
        String cents = barcode.substring(1+16+6,1+16+6+2);
        String rfRef = barcode.substring(1+16+6+2,1+16+6+2+23);
        String dueDateString = barcode.substring(1+16+6+2+23,1+16+6+2+23+6);

        String rfRefStart = rfRef.substring(0,2);
        String rfRefEnd = rfRef.substring(2,23);
        rfRefEnd = rfRefEnd.replaceFirst("^0+(?!$)", ""); // Remove zero paddings

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date dueDate = null;
        try {
            if (!dueDateString.replaceAll("0", "").trim().equals("")) {
                dueDate = format.parse("20"+dueDateString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Payment payment = new Payment();
        payment.setReceiver(new IBAN(getCountryCode(receiver)+receiver));
        payment.setAmount(Double.valueOf(euros) + Double.valueOf(cents) / 100.0);
        payment.setReference("RF"+rfRefStart+rfRefEnd);
        payment.setDueDate(dueDate);

        return payment;

    }

    private static String getCountryCode(String iban) {
        return "FI";
    }

}