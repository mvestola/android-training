package com.houston_inc.domain;

public class IBAN {

    String accountNumber;

    public IBAN(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return accountNumber;
    }
}
