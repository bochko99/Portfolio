package com.crypterium.cryptApi.pojos.kokard


import com.crypterium.cryptApi.pojos.wallets.Currency
import com.fasterxml.jackson.annotation.JsonProperty

data class PayloadOffer(
        @JsonProperty("amount")
        var amount: Amount,
        @JsonProperty("fromCurrency")
        var fromCurrency: Currency,
        @JsonProperty("toCurrency")
        var toCurrency: Currency
)