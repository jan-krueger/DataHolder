/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Jan Krüger
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 *
 */

package de.SweetCode.DataHolder.utils;

import java.util.NoSuchElementException;

/**
 * Created by Yonas on 30.10.2015.
 */
public class Optional<T> {

    private T value;

    public Optional(T value) {
        this.value = value;
    }

    /**
     * If a value is present in this Optional, returns the value, otherwise throws NoSuchElementException.
     * @return T
     */
    public T get() {

        if(!(this.isPresent())) {
            throw new NoSuchElementException();
        }

        return this.value;

    }

    /**
     * Return true if there is a value present, otherwise false.
     * @return boolean
     */
    public boolean isPresent() {
        return (!(this.value == null));
    }

    /**
     * Return the value if present, otherwise return other.
     * @param other
     * @return T
     */
    public T orElse(T other) {

        return (this.isPresent() ? this.value : other);

    }

    /**
     * Return the contained value, if present, otherwise throw an exception to be created by the provided supplier.
     * @param throwable
     * @param <X>
     * @return T
     * @throws X
     */
    public <X extends Throwable> T orElseThrow(X throwable) throws X {

        if(!(this.isPresent())) {
            throw throwable;
        }

        return this.value;

    }

    /**
     * Returns an empty Optional instance.
     * @param <T>
     * @return T
     */
    public static <T> Optional<T> empty() {
        return new Optional<T>(null);
    }

    /**
     * Returns an Optional with the specified present non-null value.
     * @param value
     * @param <T>
     * @return T
     */
    public static <T> Optional<T> of(T value) {
        return new Optional<T>(value);
    }

    /**
     * Returns an Optional describing the specified value, if non-null, otherwise returns an empty Optional.
     * @param value
     * @param <T>
     * @return T
     */
    public static <T> Optional<T> ofNullable(T value) {

        if(value == null) {
            return Optional.empty();
        }

        return new Optional<T>(value);

    }

    @Override
    public int hashCode() {

        if(!(this.isPresent())) {
            return 0;
        }

        return this.value.hashCode();

    }

}
