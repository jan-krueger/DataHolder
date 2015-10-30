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
import de.SweetCode.DataHolder.utils.Optional;

import java.util.*;


/**
 * Created by Yonas on 15.09.2015.
 */
public class DataHolder implements DataCarrier {

    private Map<Class<?>, ArrayList<Property<?, ?>>> datas = new HashMap<>();

    public DataHolder() {}

    /**
     * Stores a Property in the DataHolder
     * @param property
     * @return Returns true if it was successfully and false if a Property with the same key already exists in the DataHolder object.
     */
    @Override
    public boolean store(final Property<?, ?> property) {

        if(this.contains(property.getClass(), property.getKey())) {
            return false;
        }

        if(this.datas.containsKey(property.getClass())) {
            this.datas.get(property.getClass()).add(property);
            return true;
        }

        this.datas.put(property.getClass(), new ArrayList<Property<?, ?>>() {{

            this.add(property);

        }});

        return true;

    }

    /**
     * Returns all stored Properties for this DataHolder.
     * @return
     */
    @Override
    public Collection<Property<?, ?>> getProperties() {

        Collection<Property<?, ?>> collection = new ArrayList<>();

        for(ArrayList<Property<?, ?>> list : this.datas.values()) {

            for(Property<?, ?> entry : list) {
                collection.add(entry);
            }

        }

        return collection;

    }

    /**
     * Returns all stored Property types.
     * @return
     */
    @Override
    public Collection<Class<?>> getPropertyTypes() {

        return this.datas.keySet();

    }

    /**
     * Returns the first stored Property.
     * @param propertyClass The property class which implements the {@see de.SweetCode.DataHolder.Property.Property} interface.
     * @param <T>
     * @return T the result, if no property is stored for the class the function will return null.
     */
    public <T extends Property<?, ?>> Optional<T> getFirstProperty(Class<T> propertyClass) {

        if(!(this.datas.containsKey(propertyClass))) {
            return Optional.empty();
        }

        return Optional.of(((T) this.datas.get(propertyClass).get(0)));

    }

    /**
     * Returns the Property by key.
     * @param <T>
     * @param propertyClass The property class which implements the {@see de.SweetCode.DataHolder.Property.Property} interface.
     * @return T the result, if no property is stored for the class the function will return null.
     */
    @Override
    public <T extends Property> Optional<T> getProperty(Class<T> propertyClass, Object key) {

        List<T> list = this.getProperties(propertyClass);

        if(list.isEmpty()) {
            return Optional.empty();
        }

        for(T entry : this.getProperties(propertyClass)) {

            if(entry.getKey().equals(key)) {
                return Optional.of(entry);
            }

        }

        return Optional.empty();

    }

    /**
     * Returns all stored Properties.
     * @param propertyClass The property class which implements the {@see de.SweetCode.DataHolder.Property.Property} interface.
     * @param <T>
     * @return Collection<T> A collection of all stored Properties of the same type if no Property is stored for the given class the function will return a empty ArrayList.
     */
    public <T extends Property<?, ?>> List<T> getProperties(Class<T> propertyClass) {

        if(!(this.datas.containsKey(propertyClass))) {
            return new ArrayList<>();
        }

        return (List<T>) this.datas.get(propertyClass);

    }

    /**
     * Returns the amount of the stored Properties
     * @return
     */
    @Override
    public int size() {
        return this.datas.size();
    }

    /**
     * Checks if the DataHolder contains the given Property class.
     * @param propertyClass The Property class
     * @param <T>
     * @return true if the DataHolder contains the Property class.
     */
    public <T extends Property<?, ?>> boolean contains(Class<T> propertyClass) {

        return (!(this.datas.get(propertyClass).isEmpty()));

    }

    /**
     * Checks if the DataHolder contains the given Property class and if the class is related with the given key.
     * @param propertyClass The Property class
     * @param <T>
     * @return true if the DataHolder contains the Property class with the related key.
     */
    @Override
    public <T extends Property<?, ?>> boolean contains(Class<T> propertyClass, Object key) {

        return this.getProperty(propertyClass, key).isPresent();

    }

    /**
     * Delets a Property that is related with a key.
     * @param propertyClass The Property class.
     * @param key The related key.
     * @param <T>
     * @return returns the deleted Property object if the DataHolder contains the given pair of Property class and key otherwise it returns null.
     */
    @Override
    public <T extends Property<?, ?>> Optional<T> deleteProperty(Class<T> propertyClass, Object key) {

        if(!(this.contains(propertyClass, key))) {
            return Optional.empty();
        }

        Optional<T> property = this.getProperty(propertyClass, key);
        this.deleteProperty(property.get());
        return property;

    }

    /**
     * Delets a Property.
     * @param property The Property object.
     * @param <T>
     * @return returns the deleted Property object if the DataHolder contains the given pair of Property class and key otherwise it returns null.
     */
    public <T extends Property<?, ?>> Optional<T> deleteProperty(T property) {

        if(!(this.contains(property.getClass(), property.getKey()))) {
            return Optional.empty();
        }

        this.datas.get(property.getClass()).remove(property);

        return Optional.of(property);

    }

    /**
     * Delets all Properties related to this Property class.
     * @param <T>
     * @param propertyClass The Property class.
     * @return returns a list of all deleted Properties.
     */
    public <T extends Property<?, ?>> List<T> deleteProperties(Class<T> propertyClass) {

        if(!(this.contains(propertyClass))) {
            return null;
        }

        List<T> properties = this.getProperties(propertyClass);
        this.datas.remove(propertyClass);
        return properties;

    }

    /**
     * Deletes all stored Properties.
     */
    @Override
    public void clear() {
        this.datas.clear();
    }

}