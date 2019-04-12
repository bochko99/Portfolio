package com.crypterium.cryptApi.exceptions;

import com.crypterium.cryptApi.pojos.wallets.Currency;

public class NoSuchWalletException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public NoSuchWalletException(String message) {
        super(message);
    }

    public NoSuchWalletException(Currency currency) {
        super(String.format("No wallet found for currency %s", currency));
    }

    public NoSuchWalletException(Currency currency, String user) {
        super(String.format("No wallet found for currency %s for user %s", currency, user));
    }
}
