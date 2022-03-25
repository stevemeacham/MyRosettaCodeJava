package com.nokamea.rosettacode.statistical.arithmetic.mean;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MeanOfTest {

    @Test
    void integers() {
        assertThrows(NullPointerException.class, () -> MeanOf.integers(null));
        assertEquals(0, MeanOf.integers(List.of(0)));
        assertEquals(1, MeanOf.integers(List.of(1)));
        assertEquals(-1, MeanOf.integers(List.of(-1)));
        assertEquals(-0, MeanOf.integers(List.of(-1, 0)));
        assertEquals(0, MeanOf.integers(List.of(1, 0)));
        assertEquals(3, MeanOf.integers(List.of(2, 3, 5)));
    }

    @Test
    void integersAsFloat() {
        assertThrows(NullPointerException.class, () -> MeanOf.integersAsFloat(null));
        assertEquals(0f, MeanOf.integersAsFloat(List.of(0)));
        assertEquals(1f, MeanOf.integersAsFloat(List.of(1)));
        assertEquals(-1, MeanOf.integersAsFloat(List.of(-1)));
        assertEquals(-0.5f, MeanOf.integersAsFloat(List.of(-1, 0)));
        assertEquals(0.5f, MeanOf.integersAsFloat(List.of(1, 0)));
        assertEquals(3 + 1 / 3f, MeanOf.integersAsFloat(List.of(2, 3, 5)));
    }

    @Test
    void integersAsDouble() {
        assertThrows(NullPointerException.class, () -> MeanOf.integersAsDouble(null));
        assertEquals(0d, MeanOf.integersAsDouble(List.of(0)));
        assertEquals(1d, MeanOf.integersAsDouble(List.of(1)));
        assertEquals(-1d, MeanOf.integersAsDouble(List.of(-1)));
        assertEquals(-0.5d, MeanOf.integersAsDouble(List.of(-1, 0)));
        assertEquals(0.5d, MeanOf.integersAsDouble(List.of(1, 0)));
        assertEquals(3 + 1 / 3d, MeanOf.integersAsDouble(List.of(2, 3, 5)));
    }

    @Test
    void floats() {
        //noinspection ConstantConditions
        assertThrows(NullPointerException.class, () -> MeanOf.floats(null));
        assertEquals(0f, MeanOf.floats(List.of(0f)), 0.1);
        assertEquals(1.4f, MeanOf.floats(List.of(1.4f)), 0.0000001);
        assertEquals(-1.6f, MeanOf.floats(List.of(-1.6f)), 0.0000001);
        assertEquals(-0.55f, MeanOf.floats(List.of(-1.3f, 0.2f)), 0.0000001);
        assertEquals(0.95f, MeanOf.floats(List.of(1.9f, 0f)), 0.0000001);
        assertEquals(11 / 3f, MeanOf.floats(List.of(2.7f, 3.2f, 5.1f)), 0.0000001);
    }

    @Test
    void doubles() {
        assertThrows(NullPointerException.class, () -> MeanOf.doubles(null));
        assertEquals(0d, MeanOf.doubles(List.of(0d)), 0.0000001);
        assertEquals(1.4d, MeanOf.doubles(List.of(1.4d)), 0.0000001);
        assertEquals(-1.6d, MeanOf.doubles(List.of(-1.6d)), 0.0000001);
        assertEquals(-0.55d, MeanOf.doubles(List.of(-1.3d, 0.2d)), 0.0000001);
        assertEquals(0.95d, MeanOf.doubles(List.of(1.9d, 0d)), 0.0000001);
        assertEquals(11 / 3d, MeanOf.doubles(List.of(2.7d, 3.2d, 5.1d)), 0.0000001);
    }

    @Test
    void bigIntegers() {
        assertThrows(NullPointerException.class, () -> MeanOf.bigIntegers(null));
        assertEquals(BigInteger.ZERO, MeanOf.bigIntegers(List.of(BigInteger.ZERO)));
        assertEquals(BigInteger.ONE, MeanOf.bigIntegers(List.of(BigInteger.valueOf(1))));
        assertEquals(BigInteger.valueOf(-1), MeanOf.bigIntegers(List.of(BigInteger.valueOf(-1))));
        assertEquals(BigInteger.ZERO, MeanOf.bigIntegers(List.of(BigInteger.valueOf(-1), BigInteger.valueOf(0))));
        assertEquals(BigInteger.ZERO, MeanOf.bigIntegers(List.of(BigInteger.valueOf(1), BigInteger.valueOf(0))));
        assertEquals(BigInteger.valueOf(3), MeanOf.bigIntegers(List.of(BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(5))));
    }

    @Test
    void bigIntegersAsBigDecimal() {
        assertThrows(NullPointerException.class, () -> MeanOf.bigIntegersAsBigDecimal(null));
        assertEquals(BigDecimal.ZERO, MeanOf.bigIntegersAsBigDecimal(List.of(BigInteger.ZERO)));
        assertEquals(BigDecimal.ONE, MeanOf.bigIntegersAsBigDecimal(List.of(BigInteger.valueOf(1))));
        assertEquals(BigDecimal.valueOf(-1), MeanOf.bigIntegersAsBigDecimal(List.of(BigInteger.valueOf(-1))));
        assertEquals(BigDecimal.valueOf(-0.5), MeanOf.bigIntegersAsBigDecimal(List.of(BigInteger.valueOf(-1), BigInteger.valueOf(0))));
        assertEquals(BigDecimal.valueOf(0.5), MeanOf.bigIntegersAsBigDecimal(List.of(BigInteger.valueOf(1), BigInteger.valueOf(0))));
        //noinspection UnpredictableBigDecimalConstructorCall
        assertEquals(new BigDecimal(3.33d, new MathContext(3, RoundingMode.HALF_UP)), MeanOf.bigIntegersAsBigDecimal(List.of(BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(5)), 2, RoundingMode.HALF_UP));
    }

    @Test
    void bigDecimals() {
        assertThrows(NullPointerException.class, () -> MeanOf.bigDecimals(null));
        assertEquals(BigDecimal.ZERO, MeanOf.bigDecimals(List.of(BigDecimal.ZERO)));
        assertEquals(BigDecimal.valueOf(1.4d), MeanOf.bigDecimals(List.of(BigDecimal.valueOf(1.4d))));
        assertEquals(BigDecimal.valueOf(-1.6d), MeanOf.bigDecimals(List.of(BigDecimal.valueOf(-1.6d))));
        assertEquals(BigDecimal.valueOf(-0.55d), MeanOf.bigDecimals(List.of(BigDecimal.valueOf(-1.3d), BigDecimal.valueOf(0.2d))));
        assertEquals(BigDecimal.valueOf(0.95d), MeanOf.bigDecimals(List.of(BigDecimal.valueOf(1.9d), BigDecimal.ZERO), 2, RoundingMode.HALF_UP));
        assertEquals(BigDecimal.valueOf(3.67d), MeanOf.bigDecimals(List.of(BigDecimal.valueOf(2.7d), BigDecimal.valueOf(3.2d), BigDecimal.valueOf(5.1d)), 2, RoundingMode.HALF_UP));
    }
}
