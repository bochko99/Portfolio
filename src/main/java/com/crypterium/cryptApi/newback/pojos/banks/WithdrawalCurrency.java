package com.crypterium.cryptApi.newback.pojos.banks;

public enum WithdrawalCurrency {
    UNDEFINED("Undefined"),
    RUB("RUB"),
    EUR("EUR"),
    BTC("BTC"),
    ETH("ETH"),
    CRPT("CRPT");

    private String value;

    WithdrawalCurrency(String value) {
        this.value = value;
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
