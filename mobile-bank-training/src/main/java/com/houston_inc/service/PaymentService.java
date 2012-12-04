package com.houston_inc.service;

import com.houston_inc.domain.Payment;
import com.houston_inc.domain.SecurityKey;

public interface PaymentService {

    public void addNewPayment(Payment payment, SecurityKey key);

}
