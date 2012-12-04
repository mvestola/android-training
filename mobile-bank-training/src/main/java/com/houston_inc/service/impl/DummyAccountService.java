package com.houston_inc.service.impl;

import com.houston_inc.domain.Account;
import com.houston_inc.domain.IBAN;
import com.houston_inc.domain.SecurityKey;
import com.houston_inc.domain.User;
import com.houston_inc.exception.InvalidCredentialsException;
import com.houston_inc.exception.InvalidSecurityKeyException;
import com.houston_inc.service.AccountService;
import com.houston_inc.service.LoginProvider;

import java.util.ArrayList;
import java.util.List;

public class DummyAccountService extends AbstractNetworkRequestEmulator implements AccountService {

    private static final String VALID_USERNAME = "test";
    private static final String VALID_PASSWORD = "test";

    private static final String VALID_LOGIN_SECURITY_KEY = "123456";

    private User loggedInUser;


    public void login(String username, String password, SecurityKey key)
            throws InvalidCredentialsException, InvalidSecurityKeyException {

        emulateNetworkRequest(3000);

        boolean validUsername = username!=null && username.equals(VALID_USERNAME);
        boolean validPassword = password!=null && password.equals(VALID_PASSWORD);
        boolean validKey = key!=null && key.getKey().equals(VALID_LOGIN_SECURITY_KEY);

        if (!validPassword || !validUsername) {
            throw new InvalidCredentialsException();
        } else if (!validKey) {
            throw new InvalidSecurityKeyException(key);
        } else {
            loggedInUser = new User();
            loggedInUser.setUsername(username);
            loggedInUser.setUserId(1);
        }

    }

    @Override
    public List<Account> getAccounts() {

        List<Account> list = new ArrayList<Account>();
        list.add(new Account(new IBAN("FI1234567890"), 1234.56, "Company account"));
        list.add(new Account(new IBAN("FI1234567891"), 1000000.0,  "Savings account"));
        list.add(new Account(new IBAN("FI1234567892"), 12.54, "My account"));
        list.add(new Account(new IBAN("FI1234567893"), -100.4, "Wife's account"));

        return list;

    }

}
