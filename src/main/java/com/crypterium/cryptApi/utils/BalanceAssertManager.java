package com.crypterium.cryptApi.utils;

import org.junit.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BalanceAssertManager {

    public static int compare(BigDecimal first, BigDecimal second) {
        int scale = Integer.min(first.scale(), second.scale());
        return first.setScale(scale, RoundingMode.HALF_UP).compareTo(second.setScale(scale, RoundingMode.HALF_UP));
    }

    public static int compare(BigDecimal first, BigDecimal second, int scale) {
        return first.setScale(scale, RoundingMode.HALF_UP).compareTo(second.setScale(scale, RoundingMode.HALF_UP));
    }

    public static int compare(BigDecimal first, BigDecimal second, int scale, RoundingMode mode) {
        return first.setScale(scale, mode).compareTo(second.setScale(scale, mode));
    }

    public static boolean equal(BigDecimal first, BigDecimal second) {
        int scale = Integer.min(first.scale(), second.scale());
        scale = scale <= 4 ? 4 : scale - 1;
        return equal(first, second, scale);
    }

    public static boolean equal(BigDecimal first, BigDecimal second, int scale) {
        return first.stripTrailingZeros().setScale(scale, RoundingMode.UP).compareTo(second.stripTrailingZeros().setScale(scale, RoundingMode.UP)) == 0
                || first.stripTrailingZeros().setScale(scale, RoundingMode.DOWN).compareTo(second.stripTrailingZeros().setScale(scale, RoundingMode.DOWN)) == 0;
    }

    public static boolean equal(BigDecimal first, BigDecimal second, int scale, RoundingMode mode) {
        return first.stripTrailingZeros().setScale(scale, mode).compareTo(second.stripTrailingZeros().setScale(scale, mode)) == 0;
    }

    public static void assertEquals(BigDecimal first, BigDecimal second) {
        String msg = String.format("Expected: %s, Actual: %s", first, second);
        Assert.assertTrue(msg, equal(first, second));
    }

}
