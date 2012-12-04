package com.houston_inc.service;

import com.houston_inc.domain.Account;
import com.houston_inc.domain.SecurityKey;
import com.houston_inc.domain.Transaction;

import java.util.List;

public interface TransactionService {

    public List<Transaction> getTransactions(Account account, SecurityKey key);

}
