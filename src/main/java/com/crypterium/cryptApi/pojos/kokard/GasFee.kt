package com.crypterium.cryptApi.pojos.kokard


import com.crypterium.cryptApi.pojos.wallets.Currency
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class GasFee(
        @JsonProperty("currency")
        var currency: Currency?,
        @JsonProperty("value")
        var value: BigDecimal?
)