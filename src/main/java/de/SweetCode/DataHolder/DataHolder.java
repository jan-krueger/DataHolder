package de.SweetCode.DataHolder;

import com.google.common.collect.ArrayListMultimap;
import de.SweetCode.DataHolder.Property.Property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Yonas on 15.09.2015.
 */
public class DataHolder {

    private ArrayListMultimap<Class<?>, Property<?, ?>> datas = ArrayListMultimap.create();

    /**
     * Stores a Property in the DataHolder
     * @param property
     * @return Returns true if it was successfully and false if a Property with the same key already exists in the DataHolder object.
     */
    public boolean store(Property<?, ?> property) {

        if(!(this.getProperty(property.getClass(), property.getKey()) == null)) {
            return false;
        }

        this.datas.put(property.getClass(), property);

        return true;

    }

    /**
     * Returns all stored Properties for this DataHolder.
     * @return
     */
    public Collection<Property<?, ?>> getProperties() {

        return this.datas.values();

    }

    /**
     * Returns all stored Property types.
     * @return
     */
    public Collection<Class<?>> getPropertieTypes() {

        return this.datas.keySet();

    }

    /**
     * Returns the first stored Property.
     * @param propertyClass The property class which implements the {@see de.SweetCode.DataHolder.Property.Property} interface.
     * @param <T>
     * @return T the result, if no property is stored for the class the function will return null.
     */
    public <T extends Property<?, ?>> T getFirstProperty(Class<T> propertyClass) {

        if(!(this.datas.containsKey(propertyClass))) {
            return null;
        }

        return ((T) this.datas.get(propertyClass).get(0));

    }

    /**
     * Returns the Property by key.
     * @param <T>
     * @param propertyClass The property class which implements the {@see de.SweetCode.DataHolder.Property.Property} interface.
     * @return T the result, if no property is stored for the class the function will return null.
     */
    public <T extends Property<?, ?>> Property<?, ?> getProperty(Class<T> propertyClass, Object key) {

        List<Property<?, ?>> list = this.getProperties(propertyClass);

        if(list.isEmpty()) {
            return null;
        }

        for(Property<?, ?> entry : this.getProperties(propertyClass)) {

            if(entry.getKey().equals(key)) {
                return entry;
            }

        }

        return null;

    }

    /**
     * Returns all stored Properties.
     * @param propertyClass The property class which implements the {@see de.SweetCode.DataHolder.Property.Property} interface.
     * @param <T>
     * @return Collection<T> A collection of all stored Properties of the same type.
     */
    public <T extends Property<?, ?>> List<Property<?, ?>> getProperties(Class<T> propertyClass) {

        if(!(this.datas.containsKey(propertyClass))) {
            return new ArrayList<>();
        }

        return this.datas.get(propertyClass);

    }

}