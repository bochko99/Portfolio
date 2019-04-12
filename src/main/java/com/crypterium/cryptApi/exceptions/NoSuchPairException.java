package com.crypterium.cryptApi.exceptions;

import com.crypterium.cryptApi.pojos.wallets.Currency;

public class NoSuchPairException extends RuntimeException {

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public NoSuchPairException() {

    }

    public NoSuchPairException(Currency currencyFrom, Currency currencyTo) {
        super(String.format("Pair %s->%s not found", currencyFrom, currencyTo));
    }
}
