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

package de.SweetCode.DataHolder;

import de.SweetCode.DataHolder.Property.Property;

import java.util.Collection;

/**
 * Created by Yonas on 22.09.2015.
 */
public interface DataCarrier {

    /**
     * Stores a Property in the DataHolder
     * @param property
     * @return Returns true if it was successfully and false if a Property with the same key already exists in the DataHolder object.
     */
    boolean store(Property<?, ?> property);

    /**
     * Returns all stored Properties for this DataHolder.
     * @return
     */
    Collection<Property<?, ?>> getProperties();

    /**
     * Returns all stored Property types.
     * @return
     */
    Collection<Class<?>> getPropertyTypes();

    /**
     * Returns the Property by key.
     * @param <T>
     * @param propertyClass The property class which implements the {@see de.SweetCode.DataHolder.Property.Property} interface.
     * @return T the result, if no property is stored for the class the function will return null.
     */
    <T extends Property> Property<?, ?> getProperty(Class<T> propertyClass, Object key);

    /**
     * Checks if the DataHolder contains the given Property class and if the class is related with the given key.
     * @param propertyClass The Property class
     * @param <T>
     * @return true if the DataHolder contains the Property class with the related key.
     */
    <T extends Property<?, ?>> boolean contains(Class<T> propertyClass, Object key);

    /**
     * Delets a Property that is related with a key.
     * @param propertyClass The Property class.
     * @param key The related key.
     * @param <T>
     * @return returns the deleted Property object if the DataHolder contains the given pair of Property class and key otherwise it returns null.
     */
    <T extends Property<?, ?>> T deleteProperty(Class<T> propertyClass, Object key);

    /**
     * Returns the size.
     * @return
     */
    int size();

    /**
     * Deletes all stored Properties.
     */
    void clear();

}
