package com.houston_inc.util;

import com.houston_inc.domain.Payment;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PaymentUtilTest {


    @Test
    public void testV5() throws Exception {

        /**
         * Should return:
         *
         * Tilinro: ÅAB FI15 6601 0001 5306 41
         * Summa: 7 444,54
         * Viite: RF84 7758 4747 9064 7489
         * Eräpäivä: 19.12.2019
         *
         */
        Payment payment = PaymentUtil.gePaymentFromBarcode("515660100015306410074445484000007758474790647489191219");

        assertEquals("FI1566010001530641", payment.getReceiver().toString());
        assertEquals(7444.54, payment.getAmount(), 0.0);
        assertEquals("RF847758474790647489", payment.getReference());
        assertEquals(new SimpleDateFormat("dd.MM.yyyy").parse("19.12.2019"), payment.getDueDate());


        /**
         * Should return:
         *
         * Tilinro: Handelsbanken FI73 3131 3001 0000 58
         * Summa: 0,00
         * Viite: RF10 8686 24
         * Eräpäivä: 9.8.2013
         *
         */
        payment = PaymentUtil.gePaymentFromBarcode("573313130010000580000000010000000000000000868624130809");

        assertEquals("FI7331313001000058", payment.getReceiver().toString());
        assertEquals(0.00, payment.getAmount(), 0.0);
        assertEquals("RF10868624", payment.getReference());
        assertEquals(new SimpleDateFormat("dd.MM.yyyy").parse("09.08.2013"), payment.getDueDate());


        /**
         * Should return:
         *
         * Tilinro: SEB FI83 3301 0001 1007 75
         * Summa:
         * Viite: RF71 9212 5374 2525 3989 7737
         * Eräpäivä: 25.5.2016
         *
         */
        payment = PaymentUtil.gePaymentFromBarcode("583330100011007751500002071092125374252539897737160525");

        assertEquals("FI8333010001100775", payment.getReceiver().toString());
        assertEquals(150000.20, payment.getAmount(), 0.0);
        assertEquals("RF7192125374252539897737", payment.getReference());
        assertEquals(new SimpleDateFormat("dd.MM.yyyy").parse("25.05.2016"), payment.getDueDate());

    }

    @Test
    public void testV4() throws Exception {

        /**
         * Should return:
         *
         * Tilinro: Sp. FI79 4405 2020 0360 82
         * Summa: 4 883,15
         * Viite: 86851 62596 19897
         * Eräpäivä: 12.6.2010
         */
        Payment payment = PaymentUtil.gePaymentFromBarcode("479440520200360820048831500000000868516259619897100612");

        assertEquals("FI7944052020036082", payment.getReceiver().toString());
        assertEquals(4883.15, payment.getAmount(), 0.0);
        assertEquals("868516259619897", payment.getReference());
        assertEquals(new SimpleDateFormat("dd.MM.yyyy").parse("12.06.2010"), payment.getDueDate());


        /**
         * Should return:
         *
         * Tilinro: Op. FI02 5000 4640 0013 02
         * Summa: 693,80
         * Viite: 69 87567 20834 35364
         * Eräpäivä: 24.7.2011
         */

        payment = PaymentUtil.gePaymentFromBarcode("402500046400013020006938000000069875672083435364110724");

        assertEquals("FI0250004640001302", payment.getReceiver().toString());
        assertEquals(693.80, payment.getAmount(), 0.0);
        assertEquals("69875672083435364", payment.getReference());
        assertEquals(new SimpleDateFormat("dd.MM.yyyy").parse("24.07.2011"), payment.getDueDate());


        /**
         * Should return:
         *
         * Tilinro: S-Pankki FI92 3939 0001 0033 91
         * Summa: 0,02
         * Viite: 13 57914
         * Eräpäivä: 24.12.2099
         */

        payment = PaymentUtil.gePaymentFromBarcode("492393900010033910000000200000000000000001357914991224");

        assertEquals("FI9239390001003391", payment.getReceiver().toString());
        assertEquals(0.02, payment.getAmount(), 0.0);
        assertEquals("1357914", payment.getReference());
        assertEquals(new SimpleDateFormat("dd.MM.yyyy").parse("24.12.2099"), payment.getDueDate());


        /**
         * Should return:
         *
         * Tilinro: Sampo FI16 8000 1400 0502 67
         * Summa: 935,85
         * Viite: 78 77767 96566 28687
         * Eräpäivä: Ei eräpäivää
         */

        payment = PaymentUtil.gePaymentFromBarcode("416800014000502670009358500000078777679656628687000000");

        assertEquals("FI1680001400050267", payment.getReceiver().toString());
        assertEquals(935.85, payment.getAmount(), 0.0);
        assertEquals("78777679656628687", payment.getReference());
        assertNull(payment.getDueDate());


    }

    @Test
    public void testErrors() throws Exception {

        assertNull(PaymentUtil.gePaymentFromBarcode(null));
        assertNull(PaymentUtil.gePaymentFromBarcode(""));

        assertNull(PaymentUtil.gePaymentFromBarcode("41"));
        assertNull(PaymentUtil.gePaymentFromBarcode("51"));
        assertNull(PaymentUtil.gePaymentFromBarcode("41680001400050267000935850000007877767965662868700000"));
        assertNull(PaymentUtil.gePaymentFromBarcode("51680001400050267000935850000007877767965662868700000"));


    }

}
