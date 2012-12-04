package com.houston_inc.service.impl;

import com.houston_inc.domain.SecurityKey;
import com.houston_inc.domain.User;
import com.houston_inc.exception.InvalidCredentialsException;
import com.houston_inc.exception.InvalidSecurityKeyException;
import com.houston_inc.service.LoginProvider;

public class DummyLoginProvider implements LoginProvider {

    private static final String VALID_USERNAME = "test";
    private static final String VALID_PASSWORD = "test";

    private static final String VALID_LOGIN_SECURITY_KEY = "123456";

    private User loggedInUser;

    @Override
    public void login(String username, String password, SecurityKey key)
            throws InvalidCredentialsException, InvalidSecurityKeyException {

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
    public void logout() {
        loggedInUser = null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

}
