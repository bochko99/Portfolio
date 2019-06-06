package com.crypterium.cryptApi.pojos.kokard


import com.fasterxml.jackson.annotation.JsonProperty

data class PayloadCurrencyData(
        @JsonProperty("cardBalance")
        var cardBalance: CardBalance?,
        @JsonProperty("fromLimits")
        var fromLimits: FromLimits?,
        @JsonProperty("params")
        var params: Params?,
        @JsonProperty("toLimits")
        var toLimits: ToLimits?
)