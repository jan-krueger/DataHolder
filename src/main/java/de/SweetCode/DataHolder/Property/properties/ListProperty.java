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

package de.SweetCode.DataHolder.Property.properties;

import de.SweetCode.DataHolder.Property.Property;
import de.SweetCode.DataHolder.utils.Optional;

import java.util.List;

/**
 * Created by Yonas on 18.09.2015.
 */
public class ListProperty<K> implements Property<K, List> {

    private K key;
    private Optional<List> value;

    public ListProperty(K key, Optional<List> value) {
        this.key = key;
        this.value = value;
    }

    public ListProperty(K key, List value) {
        this(key, Optional.of(value));
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public Optional<List> getValue() {
        return this.value;
    }

    @Override
    public Property<K, List> update(Object value) {

        if(!(value instanceof List)) {
            throw new IllegalArgumentException("The value must be a List.");
        }

        this.value = Optional.of((List) value);

        return this;

    }

}
