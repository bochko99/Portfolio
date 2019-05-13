package com.crypterium.cryptApi.exceptions;

import com.crypterium.cryptApi.pojos.wallets.Currency;

public class NoSuchRateException extends RuntimeException {

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public NoSuchRateException() {

    }

    public NoSuchRateException(Currency currencyFrom) {
        super(String.format("Rate for currency %s not found", currencyFrom));
    }
}
