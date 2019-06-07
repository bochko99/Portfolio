package com.crypterium.cryptApi.utils

import org.junit.jupiter.api.Assertions.assertTrue
import java.math.BigDecimal
import java.math.RoundingMode

object BalanceAssertManager {

    @JvmStatic
    fun compare(first: BigDecimal,
                second: BigDecimal,
                scale: Int = Integer.min(first.scale(), second.scale()),
                mode: RoundingMode = RoundingMode.HALF_UP
    ): Int {
        return first.setScale(scale, mode).compareTo(second.setScale(scale, mode))
    }

    @JvmStatic
    fun equal(
            first: BigDecimal,
            second: BigDecimal
    ): Boolean {
        var scale = Integer.min(first.stripTrailingZeros().scale(), second.stripTrailingZeros().scale())
        scale = if (scale <= 1) 1 else scale - 1
        return equal(first, second, scale)
    }

    @JvmStatic
    fun equal(
            first: BigDecimal,
            second: BigDecimal,
            scale: Int
    ): Boolean {
        val delta = BigDecimal.ONE.divide(BigDecimal(Math.pow(10.0, scale.toDouble())), scale, RoundingMode.HALF_UP)
        val diff = first.subtract(second).abs()
        return diff >= BigDecimal.ZERO && diff <= delta
    }

    @JvmStatic
    fun equal(first: BigDecimal, second: BigDecimal, scale: Int, mode: RoundingMode): Boolean {
        return first.stripTrailingZeros().setScale(scale, mode).compareTo(second.stripTrailingZeros().setScale(scale, mode)) == 0
    }

    @JvmStatic
    fun assertEquals(msg: String, actual: BigDecimal, expected: BigDecimal) {
        assertTrue(equal(actual, expected), "$msg. Actual: $actual, Expected: $expected")
    }

    @JvmStatic
    fun diffPercent(first: BigDecimal, second: BigDecimal): BigDecimal {
        return first.minus(second).divide(first, 10, RoundingMode.HALF_UP)
    }

    @JvmStatic
    fun assertClose(
            msg: String = "",
            actual: BigDecimal,
            expected: BigDecimal,
            percent: BigDecimal = BigDecimal("0.5")
    ) {
        val diff = diffPercent(actual, expected)
        return assertTrue(diff <= percent, "$msg. Actual: $actual. Expected: $expected. Diff: $diff%")
    }

}