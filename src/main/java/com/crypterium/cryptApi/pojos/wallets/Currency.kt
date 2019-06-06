package com.crypterium.cryptApi.pojos.wallets

import java.math.BigDecimal

enum class Currency(
        val currency: String,
        val isCrypto: Boolean,
        minValueToSendPhoneString: String = "0"
) {

    BTC(
            currency = "BTC",
            isCrypto = true,
            minValueToSendPhoneString = "0.0001"
    ),
    ETH(
            currency = "ETH",
            isCrypto = true,
            minValueToSendPhoneString = "0.0001"
    ),
    LTC(
            currency = "LTC",
            isCrypto = true,
            minValueToSendPhoneString = "0.001"
    ),
    CRPT(
            currency = "CRPT",
            isCrypto = true,
            minValueToSendPhoneString = "0.01"
    ),
    USDC(
            currency = "USDC",
            isCrypto = true,
            minValueToSendPhoneString = "0.01"
    ),
    EUR(
            currency = "EUR",
            isCrypto = false
    ),
    USD(
            currency = "USD",
            isCrypto = false
    ),
    XRP(
            currency = "XPR",
            isCrypto = true
    );

    val minValueToSendPhone: BigDecimal = BigDecimal(minValueToSendPhoneString)

}