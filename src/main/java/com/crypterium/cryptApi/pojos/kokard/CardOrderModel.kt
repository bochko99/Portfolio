package com.crypterium.cryptApi.pojos.kokard

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class CardOrderModel(
        var dateOfBirth: String? = null,
        var documentsAndDataStatus: DocumentsAndDataStatus? = null,
        var email: String? = null,
        var firstName: String? = null,
        var kokardRejected: Boolean? = null,
        var lastName: String? = null,
        var nationality: String? = null,
        var notCompletedData: List<Any?>? = null,
        var requirementDocuments: List<RequirementDocument?>? = null,
        var residentialAddress: ResidentialAddress? = null
)