package com.crypterium.cryptApi.pojos.kokard


import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class FromLimits(
        @JsonProperty("max")
        var max: BigDecimal,
        @JsonProperty("min")
        var min: BigDecimal
)