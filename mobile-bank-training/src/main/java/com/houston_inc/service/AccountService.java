package com.houston_inc.service;

import com.houston_inc.domain.Account;
import com.houston_inc.domain.SecurityKey;
import com.houston_inc.domain.User;

import java.util.List;

public interface AccountService {

    public List<Account> getAccounts();
    public Account getAccount(Integer index);


}
