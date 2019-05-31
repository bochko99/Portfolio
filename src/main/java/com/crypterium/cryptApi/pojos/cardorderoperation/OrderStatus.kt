package com.crypterium.cryptApi.pojos.cardorderoperation


import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class OrderStatus(
        @JsonProperty("cardApplyStatus")
        var cardApplyStatus: String? = null,
        @JsonProperty("cardOrderExperimentGroup")
        var cardOrderExperimentGroup: String? = null,
        @JsonProperty("cardOrderStatus")
        var cardOrderStatus: String? = null,
        @JsonProperty("cardStatus")
        var cardStatus: String? = null,
        @JsonProperty("invitedNumber")
        var invitedNumber: Int? = null,
        @JsonProperty("queueNumber")
        var queueNumber: Int? = null,
        @JsonProperty("referralBonus")
        var referralBonus: Int? = null,
        @JsonProperty("status")
        var status: String? = null
)