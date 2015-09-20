package de.SweetCode.DataHolder.Property.properties;

import de.SweetCode.DataHolder.Property.Property;

import java.util.List;
import java.util.Optional;

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
    public Optional<List> get() {
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
