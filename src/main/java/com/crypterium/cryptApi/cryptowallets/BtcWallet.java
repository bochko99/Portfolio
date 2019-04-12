package com.crypterium.cryptApi.cryptowallets;

import com.crypterium.cryptApi.pojos.external.Transaction;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;

public class BtcWallet extends BasicWallet {

    private static final String API_KEY = "46d3-090c-3a75-3c66";
    private static final String PIN = "1q2w3e4r";
    private static final String ADDRESS = "3964TbBKN1pCaojdfWAVh8LoaiXRcpHNYV";

    private RequestSpecification specification = new RequestSpecBuilder()
            .setBaseUri("https://block.io")
            .setBasePath("/api/v2")
            .addQueryParam("api_key", API_KEY)
            .build();

    @Override
    public BigDecimal getBalance() {
        String balance = getSpec().queryParam("adresses", ADDRESS).get("/get_address_balance").body()
                .jsonPath().getString("data.available_balance");
        return new BigDecimal(balance);
    }

    @Override
    public Transaction sendTransaction(String receiveAddress, BigDecimal amount) {
        JsonPath response = getSpec().queryParam("amounts", amount)
                .queryParam("from_addresses", ADDRESS)
                .queryParam("to_addresses", receiveAddress)
                .queryParam("pin", PIN)
                .post("withdraw_from_addresses").jsonPath();
        return response.getObject("data", Transaction.class);
    }

    @Override
    protected RequestSpecification getSpec() {
        return given().spec(specification);
    }

}
