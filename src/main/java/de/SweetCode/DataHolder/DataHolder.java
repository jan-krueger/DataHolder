package de.SweetCode.DataHolder;

import de.SweetCode.DataHolder.Property.Property;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yonas on 15.09.2015.
 */
public class DataHolder {

    private Map<Class<?>, Property<?, ?>> datas = new HashMap<>();

    public void store(Property<?, ?> property) {
        this.datas.put(property.getClass(), property);
    }

    public Collection<Property<?, ?>> getProperties() {

        return this.datas.values();

    }

    public <T extends Property<?, ?>> T getProperty(Class<T> propertyClass) {

        return (T) this.datas.get(propertyClass);

    }

}