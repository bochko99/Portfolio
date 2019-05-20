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
        int scale = Integer.min(first.stripTrailingZeros().scale(), second.stripTrailingZeros().scale());
        scale = scale <= 1 ? 1 : scale - 1;
        return equal(first, second, scale);
    }

    public static boolean equal(BigDecimal first, BigDecimal second, int scale) {
        BigDecimal delta = BigDecimal.ONE.divide(new BigDecimal(Math.pow(10, scale)), scale, RoundingMode.HALF_UP);
        BigDecimal diff = first.subtract(second).abs();
        return diff.compareTo(BigDecimal.ZERO) >= 0
                && diff.compareTo(delta) <= 0;
    }

    public static boolean equal(BigDecimal first, BigDecimal second, int scale, RoundingMode mode) {
        return first.stripTrailingZeros().setScale(scale, mode).compareTo(second.stripTrailingZeros().setScale(scale, mode)) == 0;
    }

    public static void assertEquals(String msg, BigDecimal actual, BigDecimal expected) {
        String msgTemp = String.format("%s. Actual: %s, Expected: %s", msg, actual, expected);
        Assert.assertTrue(msgTemp, equal(actual, expected));
    }

}