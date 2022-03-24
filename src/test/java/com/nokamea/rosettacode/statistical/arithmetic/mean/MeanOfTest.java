package com.nokamea.rosettacode.statistical.arithmetic.mean;

import com.nokamea.rosettacode.statistical.median.MedianOf;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MeanOfTest {

    @Test
    void integers() {
        assertThrows(NullPointerException.class, () -> com.nokamea.rosettacode.statistical.median.MedianOf.integers(null));
        assertThrows(IllegalArgumentException.class, () -> com.nokamea.rosettacode.statistical.median.MedianOf.integers(Collections.emptyList()));

        for (int a = -5; a <= 5; a++) {
            assertEquals(a, com.nokamea.rosettacode.statistical.median.MedianOf.integers(List.of(a)));

            for (int b = -5; b <= 5; b++) {
                assertEquals((a + b) / 2, com.nokamea.rosettacode.statistical.median.MedianOf.integers(List.of(a, b)));

                for (int c = -5; c <=5; c++) {
                    final List<Integer> listOf3 = List.of(a, b, c);
                    final int medianOf3 = listOf3.stream().sorted().toList().get(1);
                    assertEquals(medianOf3, com.nokamea.rosettacode.statistical.median.MedianOf.integers(listOf3));

                    for (int d = -5; d <=5; d++) {
                        final List<Integer> listOf4 = List.of(a, b, c, d);
                        final List<Integer> sortedListOf4 = listOf4.stream().sorted().toList();
                        final int medianOf4 = (sortedListOf4.get(1) + sortedListOf4.get(2)) / 2;
                        assertEquals(medianOf4, com.nokamea.rosettacode.statistical.median.MedianOf.integers(listOf4));

                        for (int e = -5; e <= 5; e++) {
                            final List<Integer> listOf5 = List.of(a, b, c, d, e);
                            final int medianOf5 = listOf5.stream().sorted().toList().get(2);
                            assertEquals(medianOf5, com.nokamea.rosettacode.statistical.median.MedianOf.integers(listOf5));
                        }
                    }
                }
            }
        }
    }

    @Test
    void integersAsFloat() {
        assertThrows(NullPointerException.class, () -> com.nokamea.rosettacode.statistical.median.MedianOf.integersAsFloat(null));
        assertThrows(IllegalArgumentException.class, () -> com.nokamea.rosettacode.statistical.median.MedianOf.integersAsFloat(Collections.emptyList()));

        for (int a = -5; a <= 5; a++) {
            assertEquals(a, com.nokamea.rosettacode.statistical.median.MedianOf.integersAsFloat(List.of(a)));

            for (int b = -5; b <= 5; b++) {
                assertEquals((a + b) / 2f, com.nokamea.rosettacode.statistical.median.MedianOf.integersAsFloat(List.of(a, b)));

                for (int c = -5; c <=5; c++) {
                    final List<Integer> listOf3 = List.of(a, b, c);
                    final Float medianOf3 = listOf3.stream().sorted().toList().get(1).floatValue();
                    assertEquals(medianOf3, com.nokamea.rosettacode.statistical.median.MedianOf.integersAsFloat(listOf3));

                    for (int d = -5; d <=5; d++) {
                        final List<Integer> listOf4 = List.of(a, b, c, d);
                        final List<Integer> sortedListOf4 = listOf4.stream().sorted().toList();
                        final float medianOf4 = (sortedListOf4.get(1) + sortedListOf4.get(2)) / 2f;
                        assertEquals(medianOf4, com.nokamea.rosettacode.statistical.median.MedianOf.integersAsFloat(listOf4));

                        for (int e = -5; e <= 5; e++) {
                            final List<Integer> listOf5 = List.of(a, b, c, d, e);
                            final float medianOf5 = listOf5.stream().sorted().toList().get(2);
                            assertEquals(medianOf5, com.nokamea.rosettacode.statistical.median.MedianOf.integersAsFloat(listOf5));
                        }
                    }
                }
            }
        }
    }

    @Test
    void integersAsDouble() {
        assertThrows(NullPointerException.class, () -> com.nokamea.rosettacode.statistical.median.MedianOf.integersAsDouble(null));
        assertThrows(IllegalArgumentException.class, () -> com.nokamea.rosettacode.statistical.median.MedianOf.integersAsDouble(Collections.emptyList()));

        for (int a = -5; a <= 5; a++) {
            assertEquals(a, com.nokamea.rosettacode.statistical.median.MedianOf.integersAsDouble(List.of(a)));

            for (int b = -5; b <= 5; b++) {
                assertEquals((a + b) / 2d, com.nokamea.rosettacode.statistical.median.MedianOf.integersAsDouble(List.of(a, b)));

                for (int c = -5; c <=5; c++) {
                    final List<Integer> listOf3 = List.of(a, b, c);
                    final Double medianOf3 = listOf3.stream().sorted().toList().get(1).doubleValue();
                    assertEquals(medianOf3, com.nokamea.rosettacode.statistical.median.MedianOf.integersAsDouble(listOf3));

                    for (int d = -5; d <=5; d++) {
                        final List<Integer> listOf4 = List.of(a, b, c, d);
                        final List<Integer> sortedListOf4 = listOf4.stream().sorted().toList();
                        final double medianOf4 = (sortedListOf4.get(1) + sortedListOf4.get(2)) / 2d;
                        assertEquals(medianOf4, com.nokamea.rosettacode.statistical.median.MedianOf.integersAsDouble(listOf4));

                        for (int e = -5; e <= 5; e++) {
                            final List<Integer> listOf5 = List.of(a, b, c, d, e);
                            final double medianOf5 = listOf5.stream().sorted().toList().get(2);
                            assertEquals(medianOf5, com.nokamea.rosettacode.statistical.median.MedianOf.integersAsDouble(listOf5));
                        }
                    }
                }
            }
        }
    }

    @Test
    void floats() {
        assertThrows(NullPointerException.class, () -> com.nokamea.rosettacode.statistical.median.MedianOf.floats(null));
        assertThrows(IllegalArgumentException.class, () -> com.nokamea.rosettacode.statistical.median.MedianOf.floats(Collections.emptyList()));

        for (float a = -5; a <= 5; a += 0.4f) {
            assertEquals(a, com.nokamea.rosettacode.statistical.median.MedianOf.floats(List.of(a)));

            for (float b = -5; b <= 5; b += 0.4f) {
                assertEquals((a + b) / 2, com.nokamea.rosettacode.statistical.median.MedianOf.floats(List.of(a, b)));

                for (float c = -5; c <=5; c += 0.4f) {
                    final List<Float> listOf3 = List.of(a, b, c);
                    final float medianOf3 = listOf3.stream().sorted().toList().get(1);
                    assertEquals(medianOf3, com.nokamea.rosettacode.statistical.median.MedianOf.floats(listOf3));

                    for (float d = -5; d <=5; d += 0.4f) {
                        final List<Float> listOf4 = List.of(a, b, c, d);
                        final List<Float> sortedListOf4 = listOf4.stream().sorted().toList();
                        final float medianOf4 = (sortedListOf4.get(1) + sortedListOf4.get(2)) / 2;
                        assertEquals(medianOf4, com.nokamea.rosettacode.statistical.median.MedianOf.floats(listOf4));

                        for (float e = -5; e <= 5; e += 0.4f) {
                            final List<Float> listOf5 = List.of(a, b, c, d, e);
                            final float medianOf5 = listOf5.stream().sorted().toList().get(2);
                            assertEquals(medianOf5, com.nokamea.rosettacode.statistical.median.MedianOf.floats(listOf5));
                        }
                    }
                }
            }
        }
    }

    @Test
    void doubles() {
        assertThrows(NullPointerException.class, () -> com.nokamea.rosettacode.statistical.median.MedianOf.doubles(null));
        assertThrows(IllegalArgumentException.class, () -> com.nokamea.rosettacode.statistical.median.MedianOf.doubles(Collections.emptyList()));

        for (double a = -5; a <= 5; a += 0.4d) {
            assertEquals(a, com.nokamea.rosettacode.statistical.median.MedianOf.doubles(List.of(a)));

            for (double b = -5; b <= 5; b += 0.4d) {
                assertEquals((a + b) / 2, com.nokamea.rosettacode.statistical.median.MedianOf.doubles(List.of(a, b)));

                for (double c = -5; c <=5; c += 0.4d) {
                    final List<Double> listOf3 = List.of(a, b, c);
                    final double medianOf3 = listOf3.stream().sorted().toList().get(1);
                    assertEquals(medianOf3, com.nokamea.rosettacode.statistical.median.MedianOf.doubles(listOf3));

                    for (double d = -5; d <=5; d += 0.4d) {
                        final List<Double> listOf4 = List.of(a, b, c, d);
                        final List<Double> sortedListOf4 = listOf4.stream().sorted().toList();
                        final double medianOf4 = (sortedListOf4.get(1) + sortedListOf4.get(2)) / 2;
                        assertEquals(medianOf4, com.nokamea.rosettacode.statistical.median.MedianOf.doubles(listOf4));

                        for (double e = -5; e <= 5; e += 0.4d) {
                            final List<Double> listOf5 = List.of(a, b, c, d, e);
                            final double medianOf5 = listOf5.stream().sorted().toList().get(2);
                            assertEquals(medianOf5, com.nokamea.rosettacode.statistical.median.MedianOf.doubles(listOf5));
                        }
                    }
                }
            }
        }
    }

    @Test
    void bigIntegers() {
        assertThrows(NullPointerException.class, () -> com.nokamea.rosettacode.statistical.median.MedianOf.bigIntegers(null));
        assertThrows(IllegalArgumentException.class, () -> com.nokamea.rosettacode.statistical.median.MedianOf.bigIntegers(Collections.emptyList()));

        for (BigInteger a = BigInteger.valueOf(-5); a.compareTo(BigInteger.valueOf(5)) <= 0; a = a.add(BigInteger.ONE)) {
            assertEquals(a.intValue(), com.nokamea.rosettacode.statistical.median.MedianOf.bigIntegers(List.of(a)).intValue());

            for (BigInteger b = BigInteger.valueOf(-5); b.compareTo(BigInteger.valueOf(5)) <= 0; b = b.add(BigInteger.ONE)) {
                assertEquals(a.add(b).divide(BigInteger.TWO).intValue(), com.nokamea.rosettacode.statistical.median.MedianOf.bigIntegers(List.of(a, b)).intValue());

                for (BigInteger c = BigInteger.valueOf(-5); c.compareTo(BigInteger.valueOf(5)) <= 0; c = c.add(BigInteger.ONE)) {
                    final List<BigInteger> listOf3 = List.of(a, b, c);
                    final BigInteger medianOf3 = listOf3.stream().sorted().toList().get(1);
                    assertEquals(medianOf3.intValue(), com.nokamea.rosettacode.statistical.median.MedianOf.bigIntegers(listOf3).intValue());

                    for (BigInteger d = BigInteger.valueOf(-5); d.compareTo(BigInteger.valueOf(5)) <= 0; d = d.add(BigInteger.ONE)) {
                        final List<BigInteger> listOf4 = List.of(a, b, c, d);
                        final List<BigInteger> sortedListOf4 = listOf4.stream().sorted().toList();
                        final BigInteger medianOf4 = (sortedListOf4.get(1).add(sortedListOf4.get(2))).divide(BigInteger.TWO);
                        assertEquals(medianOf4.intValue(), com.nokamea.rosettacode.statistical.median.MedianOf.bigIntegers(listOf4).intValue());

                        for (BigInteger e = BigInteger.valueOf(-5); e.compareTo(BigInteger.valueOf(5)) <= 0; e = e.add(BigInteger.ONE)) {
                            final List<BigInteger> listOf5 = List.of(a, b, c, d, e);
                            final BigInteger medianOf5 = listOf5.stream().sorted().toList().get(2);
                            assertEquals(medianOf5.intValue(), com.nokamea.rosettacode.statistical.median.MedianOf.bigIntegers(listOf5).intValue());
                        }
                    }
                }
            }
        }
    }

    @Test
    void bigIntegersAsBigDecimal() {
        assertThrows(NullPointerException.class, () -> com.nokamea.rosettacode.statistical.median.MedianOf.bigIntegersAsBigDecimal(null));
        assertThrows(IllegalArgumentException.class, () -> com.nokamea.rosettacode.statistical.median.MedianOf.bigIntegersAsBigDecimal(Collections.emptyList()));

        for (int aa = -5; aa <= 5; aa++) {
            final BigInteger a = BigInteger.valueOf(aa);
            final int aComparison = BigDecimal.valueOf(aa).compareTo(com.nokamea.rosettacode.statistical.median.MedianOf.bigIntegersAsBigDecimal(List.of(a)));
            assertEquals(0, aComparison);

            for (int bb = -5; bb <= 5; bb++) {
                final BigInteger b = BigInteger.valueOf(bb);
                final int bComparison = (BigDecimal.valueOf(aa + bb).divide(BigDecimal.valueOf(2), RoundingMode.FLOOR)).compareTo(com.nokamea.rosettacode.statistical.median.MedianOf.bigIntegersAsBigDecimal(List.of(a, b)));
                assertEquals(0, bComparison);

                for (int cc = -5; cc <= 5; cc++) {
                    final BigInteger c = BigInteger.valueOf(cc);
                    final List<BigInteger> listOf3 = List.of(a, b, c);
                    final BigDecimal medianOf3 = new BigDecimal(listOf3.stream().sorted().toList().get(1));
                    final int cComparison = medianOf3.compareTo(com.nokamea.rosettacode.statistical.median.MedianOf.bigIntegersAsBigDecimal(listOf3));
                    assertEquals(0, cComparison);

                    for (int dd = -5; dd <= 5; dd++) {
                        final BigInteger d = BigInteger.valueOf(dd);
                        final List<BigInteger> listOf4 = List.of(a, b, c, d);
                        final List<BigInteger> sortedListOf4 = listOf4.stream().sorted().toList();
                        final BigDecimal medianOf4 = (new BigDecimal(sortedListOf4.get(1).add(sortedListOf4.get(2)))).divide(BigDecimal.valueOf(2), RoundingMode.FLOOR);
                        final int dComparison = medianOf4.compareTo(com.nokamea.rosettacode.statistical.median.MedianOf.bigIntegersAsBigDecimal(listOf4));
                        assertEquals(0, dComparison);

                        for (int ee = -5; ee <= 5; ee++) {
                            final BigInteger e = BigInteger.valueOf(ee);
                            final List<BigInteger> listOf5 = List.of(a, b, c, d, e);
                            final BigDecimal medianOf5 = new BigDecimal(listOf5.stream().sorted().toList().get(2));
                            final int eComparison = medianOf5.compareTo(com.nokamea.rosettacode.statistical.median.MedianOf.bigIntegersAsBigDecimal(listOf5));
                            assertEquals(0, eComparison);
                        }
                    }
                }
            }
        }
    }

    @Test
    void bigDecimals() {
        assertThrows(NullPointerException.class, () -> com.nokamea.rosettacode.statistical.median.MedianOf.bigDecimals(null));
        assertThrows(IllegalArgumentException.class, () -> com.nokamea.rosettacode.statistical.median.MedianOf.bigDecimals(Collections.emptyList()));

        for (float a = -5; a <= 5; a += 0.4d) {
            final BigDecimal ba = BigDecimal.valueOf(a);
            assertEquals(ba, com.nokamea.rosettacode.statistical.median.MedianOf.bigDecimals(List.of(ba)));

            for (float b = -5; b <= 5; b += 0.4d) {
                final BigDecimal bb = BigDecimal.valueOf(b);
                assertEquals(ba.add(bb).divide(BigDecimal.valueOf(2), RoundingMode.FLOOR).doubleValue(), com.nokamea.rosettacode.statistical.median.MedianOf.bigDecimals(List.of(ba, bb)).doubleValue());

                for (float c = -5; c <= 5; c += 0.4d) {
                    final BigDecimal bc = BigDecimal.valueOf(c);
                    final List<BigDecimal> listOf3 = List.of(ba, bb, bc);
                    final BigDecimal medianOf3 = listOf3.stream().sorted().toList().get(1);
                    assertEquals(medianOf3.doubleValue(), com.nokamea.rosettacode.statistical.median.MedianOf.bigDecimals(listOf3).doubleValue());

                    for (float d = -5; d <= 5; d += 0.4d) {
                        final BigDecimal bd = BigDecimal.valueOf(d);
                        final List<BigDecimal> listOf4 = List.of(ba, bb, bc, bd);
                        final List<BigDecimal> sortedListOf4 = listOf4.stream().sorted().toList();
                        final BigDecimal medianOf4 = (sortedListOf4.get(1).add(sortedListOf4.get(2))).divide(BigDecimal.valueOf(2), RoundingMode.FLOOR);
                        assertEquals(medianOf4, com.nokamea.rosettacode.statistical.median.MedianOf.bigDecimals(listOf4));

                        for (float e = -5; e <= 5; e += 0.4d) {
                            final BigDecimal be = BigDecimal.valueOf(e);
                            final List<BigDecimal> listOf5 = List.of(ba, bb, bc, bd, be);
                            final BigDecimal medianOf5 = listOf5.stream().sorted().toList().get(2);
                            assertEquals(medianOf5.doubleValue(), MedianOf.bigDecimals(listOf5).doubleValue());
                        }
                    }
                }
            }
        }
    }
}
