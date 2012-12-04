package com.houston_inc.domain;

public class Account {

    private IBAN iban;
    private String name;
    private double balance;

    public Account(IBAN iban, double balance, String name) {
        this.iban = iban;
        this.balance = balance;
        this.name = name;
    }

    public IBAN getIban() {
        return iban;
    }

    public void setIban(IBAN iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", iban=" + iban +
                ", name='" + name + '\'' +
                '}';
    }
}
