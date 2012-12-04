package com.houston_inc.exception;

import com.houston_inc.domain.SecurityKey;

public class InvalidSecurityKeyException extends Exception {

    private SecurityKey key;

    public InvalidSecurityKeyException(SecurityKey key) {
        this.key = key;
    }

}
