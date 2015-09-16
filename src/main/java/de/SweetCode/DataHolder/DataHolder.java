package de.SweetCode.DataHolder;

import de.SweetCode.DataHolder.Property.Property;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Yonas on 15.09.2015.
 */
public class DataHolder {

    private Map<Class<?>, Property<?, ?>> datas = new HashMap<>();

    public void store(Property<?, ?> property) {
        this.datas.put(property.getClass(), property);
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
     * Returns the stored Property in a Optional class.
     * @param propertyClass The property class which implements the {@see de.SweetCode.DataHolder.Property.Property} interface.
     * @param <T>
     * @return Optional<T> the result, if no property is stored for the class the function will return a empty Optional.
     */
    public <T extends Property<?, ?>> Optional<T> getProperty(Class<T> propertyClass) {

        if(!(this.datas.containsKey(propertyClass))) {
            return Optional.empty();
        }

        return Optional.of((T) this.datas.get(propertyClass));

    }

}