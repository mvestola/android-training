package com.houston_inc.domain;

public class SecurityKey {

    private String key;

    public String getKey() {
        return key;
    }

    private SecurityKey withKey(String key) {
        this.key = key;
        return this;
    }

    public static SecurityKey valueOf(String key) {
        return new SecurityKey().withKey(key);
    }

}
