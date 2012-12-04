package com.houston_inc.service;

import com.houston_inc.domain.SecurityKey;
import com.houston_inc.exception.InvalidCredentialsException;
import com.houston_inc.exception.InvalidSecurityKeyException;

public interface LoginProvider {

    public void login(String username, String password, SecurityKey key)
            throws InvalidCredentialsException, InvalidSecurityKeyException;

    public void logout();

}
