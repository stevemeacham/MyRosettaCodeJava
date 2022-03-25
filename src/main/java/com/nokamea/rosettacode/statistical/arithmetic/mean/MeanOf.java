package com.nokamea.rosettacode.statistical.arithmetic.mean;

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
import java.util.Objects;

public class MeanOf {
    public static Integer integers(Collection<Integer> c) {
        return Objects.requireNonNull(c).stream().reduce(0, Integer::sum) / c.size();
    }

    public static Float integersAsFloat(Collection<Integer> c) {
        return Objects.requireNonNull(c).stream().reduce(0, Integer::sum).floatValue() / c.size();
    }

    public static Double integersAsDouble(Collection<Integer> c) {
        return Objects.requireNonNull(c).stream().reduce(0, Integer::sum).doubleValue() / c.size();
    }

    public static Float floats(Collection<Float> c) {
        return Objects.requireNonNull(c.stream()).reduce(0f, Float::sum) / c.size();
    }

    public static Double doubles(Collection<Double> c) {
        return Objects.requireNonNull(c).stream().reduce(0d, Double::sum) / c.size();
    }

    public static BigInteger bigIntegers(Collection<BigInteger> c) {
        return Objects.requireNonNull(c).stream().reduce(BigInteger.ZERO, BigInteger::add).divide(BigInteger.valueOf(c.size()));
    }

    @SuppressWarnings("BigDecimalMethodWithoutRoundingCalled")
    public static BigDecimal bigIntegersAsBigDecimal(Collection<BigInteger> c) {
        return new BigDecimal(Objects.requireNonNull(c).stream().reduce(BigInteger.ZERO, BigInteger::add)).divide(BigDecimal.valueOf(c.size()));
    }

    public static BigDecimal bigIntegersAsBigDecimal(Collection<BigInteger> c, int scale, RoundingMode roundingMode) {
        return new BigDecimal(Objects.requireNonNull(c).stream().reduce(BigInteger.ZERO, BigInteger::add)).divide(BigDecimal.valueOf(c.size()), scale, roundingMode);
    }

    @SuppressWarnings("BigDecimalMethodWithoutRoundingCalled")
    public static BigDecimal bigDecimals(Collection<BigDecimal> c) {
        return Objects.requireNonNull(c).stream().reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(c.size()));
    }

    public static BigDecimal bigDecimals(Collection<BigDecimal> c, int scale, RoundingMode roundingMode) {
        return Objects.requireNonNull(c).stream().reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(c.size()), scale, roundingMode);
    }
}
