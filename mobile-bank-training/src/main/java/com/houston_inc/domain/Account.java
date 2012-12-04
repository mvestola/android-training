package com.houston_inc.domain;

public class Account {

    private IBAN iban;
    private String name;

    public IBAN getIban() {
        return iban;
    }

    public void setIban(IBAN iban) {
        this.iban = iban;
    }
}
