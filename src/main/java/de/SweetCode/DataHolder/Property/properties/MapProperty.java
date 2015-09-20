package de.SweetCode.DataHolder.Property.properties;

import de.SweetCode.DataHolder.Property.Property;

import java.util.Map;
import java.util.Optional;

/**
 * Created by Yonas on 18.09.2015.
 */
public class MapProperty<K> implements Property<K, Map> {

    private K key;
    private Optional<Map> value;

    public MapProperty(K key, Optional<Map> value) {
        this.key = key;
        this.value = value;
    }

    public MapProperty(K key, Map value) {
        this(key, Optional.of(value));
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public Optional<Map> get() {
        return this.value;
    }

    @Override
    public Property<K, Map> update(Object value) {

        if(!(value instanceof Map)) {
            throw new IllegalArgumentException("The value must be a Map.");
        }

        this.value = Optional.of((Map) value);

        return this;

    }

}
