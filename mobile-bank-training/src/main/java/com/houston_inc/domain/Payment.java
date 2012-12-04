package com.houston_inc.domain;

import java.util.Date;

public class Payment {

    private double amount;
    private String payer;
    private IBAN receiver;
    private Date dueDate;
    private String reference;
    private String message;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public IBAN getReceiver() {
        return receiver;
    }

    public void setReceiver(IBAN receiver) {
        this.receiver = receiver;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
