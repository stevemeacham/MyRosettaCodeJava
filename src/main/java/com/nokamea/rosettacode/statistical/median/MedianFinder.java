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
import java.util.function.Function;

/**
 * This interface represents an operation to find the median value of a homogenous
 * {@link java.util.Collection Collection} of objects, such as {@link Float Float}. The type of the
 * objects and the type of the median may differ, such as the median of {@link Integer Integer} may be a
 * {@code Float}.
 *
 * @param <T> The type of objects in the {@code Collection}.
 * @param <R> The type of the median value that will be returned.
 */
@FunctionalInterface
interface MedianFinder<T, R> extends Function<Collection<T>, R> {

    /**
     * This method accepts a {@link Collection Collection} of elements and returns the value of the
     * median.
     *
     * @param data A {@code Collection} of elements.
     * @return The median value.
     */
    @Override
    R apply(Collection<T> data);
}
