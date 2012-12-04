package com.houston_inc.service.impl;

import com.houston_inc.domain.SecurityKey;
import com.houston_inc.exception.InvalidCredentialsException;
import com.houston_inc.exception.InvalidSecurityKeyException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DummyLoginProviderTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testLoginSuccess() throws Exception {
        DummyLoginProvider loginProvider = new DummyLoginProvider();
        loginProvider.login("test", "test", SecurityKey.valueOf("123456"));
        assertEquals("test", loginProvider.getLoggedInUser().getUsername());
    }

    @Test(expected = InvalidCredentialsException.class)
    public void testLoginFailsWrongUsername() throws Exception {
        DummyLoginProvider loginProvider = new DummyLoginProvider();
        loginProvider.login("fail", "test", SecurityKey.valueOf("123456"));
    }

    @Test(expected = InvalidCredentialsException.class)
    public void testLoginFailsWrongPassword() throws Exception {
        DummyLoginProvider loginProvider = new DummyLoginProvider();
        loginProvider.login("test", "fail", SecurityKey.valueOf("123456"));
    }

    @Test(expected = InvalidSecurityKeyException.class)
    public void testLoginFailsWrongSecurityKey() throws Exception {
        DummyLoginProvider loginProvider = new DummyLoginProvider();
        loginProvider.login("test", "test", SecurityKey.valueOf("000000"));
    }

}
