package com.crypterium.cryptApi.cryptowallets;

import com.crypterium.cryptApi.pojos.external.Transaction;
import io.restassured.specification.RequestSpecification;

import java.math.BigDecimal;

public abstract class BasicWallet {



    public abstract BigDecimal getBalance();

    public abstract Transaction sendTransaction(String receiveAddress, BigDecimal amount);

    protected abstract RequestSpecification getSpec();


}
