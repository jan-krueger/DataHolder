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

package de.SweetCode.DataHolder.DataCarriers;

import de.SweetCode.DataHolder.DataCarrier;
import de.SweetCode.DataHolder.Property.Property;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * Created by Yonas on 22.09.2015.
 */
public class DataTreeHolder implements DataCarrier {

    private Map<Class<?>, Property<?, ?>> datas = new TreeMap<>();

    public DataTreeHolder() {

    }


    @Override
    public boolean store(Property<?, ?> property) {
        datas.put(property.getClass(), property);
        return true;
    }

    @Override
    public Collection<Property<?, ?>> getProperties() {
        return this.datas.values();
    }

    @Override
    public Collection<Class<?>> getPropertyTypes() {
        return this.datas.keySet();
    }

    @Override
    public <T extends Property> Optional<T> getProperty(Class<T> propertyClass, Object key) {

        if(!(this.contains(propertyClass, key))) {
            return Optional.empty();
        }

        return Optional.of((T) this.datas.get(propertyClass));

    }

    @Override
    public <T extends Property<?, ?>> boolean contains(Class<T> propertyClass, Object key) {

        if(!(this.datas.containsKey(propertyClass))) {
            return false;
        }

        return (this.datas.get(propertyClass).getValue().get().equals(key));

    }

    @Override
    public <T extends Property<?, ?>> Optional<T> deleteProperty(Class<T> propertyClass, Object key) {

        if(!(this.contains(propertyClass, key))) {
            return Optional.empty();
        }

        return Optional.of((T) this.datas.remove(propertyClass));

    }

    @Override
    public int size() {
        return this.datas.size();
    }

    @Override
    public void clear() {
        this.datas.clear();
    }
}
