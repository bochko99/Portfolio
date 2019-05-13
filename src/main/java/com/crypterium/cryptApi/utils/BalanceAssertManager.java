package com.crypterium.cryptApi.utils;

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
        return first.setScale(scale, RoundingMode.UP).compareTo(second.setScale(scale, RoundingMode.UP)) == 0
                || first.setScale(scale, RoundingMode.DOWN).compareTo(second.setScale(scale, RoundingMode.DOWN)) == 0;
    }

    public static boolean equal(BigDecimal first, BigDecimal second, int scale) {
        return first.stripTrailingZeros().setScale(scale, RoundingMode.UP).compareTo(second.stripTrailingZeros().setScale(scale, RoundingMode.UP)) == 0
                || first.stripTrailingZeros().setScale(scale, RoundingMode.DOWN).compareTo(second.stripTrailingZeros().setScale(scale, RoundingMode.DOWN)) == 0;
    }

    public static boolean equal(BigDecimal first, BigDecimal second, int scale, RoundingMode mode) {
        return first.stripTrailingZeros().setScale(scale, mode).compareTo(second.stripTrailingZeros().setScale(scale, mode)) == 0;
    }

}
