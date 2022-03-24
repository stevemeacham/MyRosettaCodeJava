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

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * This implementation of {@link MedianFinder} contributes a convenient orchastration of finding of the median
 * by sorting the collection.
 *
 * @param <T> The type of objects in the {@link java.util.Collection Collection}.
 * @param <R> The type of the median value that will be returned.
 */
@SuppressWarnings("ClassCanBeRecord")
class MedianFinderImpl<T, R> implements MedianFinder<T, R> {

    private final Supplier<R> ifEmpty;
    private final Function<T, R> ifOdd;
    private final Function<List<T>, R> ifEven;

    /**
     * @param ifEmpty A {@link java.util.function.Supplier Supplier} to return the median of zero elements.
     * @param ifOdd   A {@link java.util.function.Function Function} to return the median of a single element.
     * @param ifEven  A {@link java.util.function.Function Function} to return the median of a
     *                {@link java.util.List List} containing two elements.
     */
    MedianFinderImpl(Supplier<R> ifEmpty,
                            Function<T, R> ifOdd,
                            Function<List<T>, R> ifEven) {
        this.ifEmpty = ifEmpty;
        this.ifOdd = ifOdd;
        this.ifEven = ifEven;
    }

    /**
     * This method implements an abstract algorithm to find the median of a {@link java.util.Collection Collection}
     * when supplied with functions to handle type-specific tasks. The process for a non-empty {@code Collection} of
     * elements is to sort the elements and take the middle element of an odd number of elements, or the average of
     * the two middle elements of an even number of elements.
     *
     * @param data    The Collection of objects.
     * @return The result of calling either {@code ifEmpty()}, {@code ifOdd()}, or {@code ifEven()}.
     */
    @Override
    public R apply(Collection<T> data) {

        //noinspection OptionalGetWithoutIsPresent
        return Objects.requireNonNull(data, "data must not be null").isEmpty()
                ? ifEmpty.get()
                : (data.size() & 1) == 0
                    ? ifEven.apply(data.stream().sorted().skip(data.size() / 2 - 1).limit(2).toList())
                    : ifOdd.apply(data.stream().sorted().skip(data.size() / 2).limit(1).findFirst().get());
    }
}
