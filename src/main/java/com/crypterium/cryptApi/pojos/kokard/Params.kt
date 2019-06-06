package com.crypterium.cryptApi.pojos.kokard


import com.fasterxml.jackson.annotation.JsonProperty

data class Params(
        @JsonProperty("fee")
        var fee: Fee?,
        @JsonProperty("gasFee")
        var gasFee: GasFee?,
        @JsonProperty("rate")
        var rate: Rate?
)