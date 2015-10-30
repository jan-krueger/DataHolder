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

    public T get() {

        if(!(this.isPresent())) {
            throw new NoSuchElementException();
        }

        return this.value;

    }

    public boolean isPresent() {
        return (!(this.value == null));
    }

    public T orElse(T other) {

        return (this.isPresent() ? this.value : other);

    }

    public T orElseThrow(Throwable throwable) throws Throwable {

        if(!(this.isPresent())) {
            throw throwable;
        }

        return this.value;

    }

    public static <T> Optional<T> empty() {
        return new Optional<T>(null);
    }

    public static <T> Optional<T> of(T value) {
        return new Optional<T>(value);
    }

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
