package com.nokamea.rosettacode.statistical.median;

/*
    This API provides a convenient functional interface for finding
    the median of a collection of numeric or other Java objects.
    Copyright © 2022  Steve Meacham

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Collection;

public class MedianOf {
    private static final MedianFinder<Integer, Integer> INTEGERS = new MedianFinderImpl<>(() -> 0, n -> n, pair -> (pair.get(0) + pair.get(1)) / 2);
    private static final MedianFinder<Integer, Float> INTEGERS_AS_FLOAT = new MedianFinderImpl<>(() -> 0f, n -> n * 1f, pair -> (pair.get(0) + pair.get(1)) / 2f);
    private static final MedianFinder<Integer, Double> INTEGERS_AS_DOUBLE = new MedianFinderImpl<>(() -> 0d, n -> n * 1d, pair -> (pair.get(0) + pair.get(1)) / 2d);
    private static final MedianFinder<Float, Float> FLOATS = new MedianFinderImpl<>(() -> 0f, n -> n, pair -> (pair.get(0) + pair.get(1)) / 2);
    private static final MedianFinder<Double, Double> DOUBLES = new MedianFinderImpl<>(() -> 0d, n -> n, pair -> (pair.get(0) + pair.get(1)) / 2);
    private static final MedianFinder<BigInteger, BigInteger> BIG_INTEGERS = new MedianFinderImpl<>(() -> BigInteger.ZERO, n -> n, pair -> pair.get(0).add(pair.get(1)).divide(BigInteger.TWO));
    private static final MedianFinder<BigInteger, BigDecimal> BIG_INTEGERS_AS_BIG_DECIMAL = new MedianFinderImpl<>(() -> BigDecimal.ZERO, BigDecimal::new, pair -> new BigDecimal(pair.get(0).add(pair.get(1))).divide(BigDecimal.valueOf(2), RoundingMode.FLOOR));
    private static final MedianFinder<BigDecimal, BigDecimal> BIG_DECIMALS = new MedianFinderImpl<>(() -> BigDecimal.ZERO, n -> n, pair -> pair.get(0).add(pair.get(1)).divide(BigDecimal.valueOf(2), RoundingMode.FLOOR));

    public static Integer    integers(Collection<Integer> integerCollection) { return INTEGERS.apply(integerCollection); }
    public static Float      integersAsFloat(Collection<Integer> integerCollection) { return INTEGERS_AS_FLOAT.apply(integerCollection); }
    public static Double     integersAsDouble(Collection<Integer> integerCollection) { return INTEGERS_AS_DOUBLE.apply(integerCollection); }
    public static Float      floats(Collection<Float> floatCollection) {
        return FLOATS.apply(floatCollection);
    }
    public static Double     doubles(Collection<Double> doubleCollection) {
        return DOUBLES.apply(doubleCollection);
    }
    public static BigInteger bigIntegers(Collection<BigInteger> bigIntegerCollection) { return BIG_INTEGERS.apply(bigIntegerCollection); }
    public static BigDecimal bigIntegersAsBigDecimal(Collection<BigInteger> bigIntegerCollection) { return BIG_INTEGERS_AS_BIG_DECIMAL.apply(bigIntegerCollection); }
    public static BigDecimal bigDecimals(Collection<BigDecimal> bigDecimalCollection) { return BIG_DECIMALS.apply(bigDecimalCollection); }
}
