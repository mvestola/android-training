package com.houston_inc.service.impl;

import com.houston_inc.domain.Account;
import com.houston_inc.domain.IBAN;
import com.houston_inc.domain.SecurityKey;
import com.houston_inc.domain.Transaction;
import com.houston_inc.service.TransactionService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DummyTransactionService implements TransactionService {


    @Override
    public List<Transaction> getTransactions(Account account, SecurityKey key) {

        List<Transaction> transactions = new ArrayList<Transaction>();

        try {

            transactions.add(new Transaction(-23.15, new SimpleDateFormat("yyyy-MM-dd").parse("2012-02-30"),
                    null, "Nalle Wahlroos", new IBAN("FI123456789"), "RF123456789"));
            transactions.add(new Transaction(-23.15, new SimpleDateFormat("yyyy-MM-dd").parse("2012-02-30"),
                    null, "Nalle Wahlroos", new IBAN("FI123456789"), "RF123456789"));

        } catch (Exception e) {

        }

        return transactions;

    }
}
