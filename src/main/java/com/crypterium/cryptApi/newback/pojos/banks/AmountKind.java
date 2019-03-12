package com.crypterium.cryptApi.newback.pojos.banks;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AmountKind {
    UNDEFINED("Undefined"),
    WITHDRAW_AMOUNT("WithdrawAmount"),
    DEPOSIT_AMOUNT("DepositAmount");

    private String value;

    AmountKind(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    /**
     * Returns the name of this enum constant, as contained in the
     * declaration.  This method may be overridden, though it typically
     * isn't necessary or desirable.  An enum type should override this
     * method when a more "programmer-friendly" string form exists.
     *
     * @return the name of this enum constant
     */
    @Override
    public String toString() {
        return this.value;
    }
}