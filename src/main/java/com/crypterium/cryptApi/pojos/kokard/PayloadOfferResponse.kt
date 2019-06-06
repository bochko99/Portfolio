package com.crypterium.cryptApi.pojos.kokard


import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class PayloadOfferResponse(
        @JsonProperty("expirationTime")
        var expirationTime: Date?,
        @JsonProperty("from")
        var from: From?,
        @JsonProperty("offerId")
        var offerId: Long?,
        @JsonProperty("params")
        var params: Params?,
        @JsonProperty("to")
        var to: To?
)