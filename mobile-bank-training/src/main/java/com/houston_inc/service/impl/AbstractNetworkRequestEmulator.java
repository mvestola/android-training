package com.houston_inc.service.impl;

/**
 * Abstract class for dummy services which emulate network requests.
 */
public abstract class AbstractNetworkRequestEmulator {

    /**
     * Emulates network request latency by simply waiting the thread.
     *
     * @param milliseconds Request length in milliseconds.
     */
    protected void emulateNetworkRequest(int milliseconds) {

        // Emulate network latency
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
