package com.houston_inc.service;

import com.houston_inc.domain.User;

public class TestService {

    public String test() {
        return "test";
    }

    public User getUser(String username) {
        return new User();
    }

}
