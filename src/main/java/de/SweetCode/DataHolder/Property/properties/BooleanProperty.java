package de.SweetCode.DataHolder.Property.properties;

import de.SweetCode.DataHolder.Property.Property;

import java.util.Optional;

/**
 * Created by Yonas on 18.09.2015.
 */
public class BooleanProperty<K> implements Property<K, Boolean> {

    private K key;
    private Optional<Boolean> value;

    public BooleanProperty(K key, Optional<Boolean> value) {
        this.key = key;
        this.value = value;
    }

    public BooleanProperty(K key, boolean value) {
        this(key, Optional.of(value));
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public Optional<Boolean> get() {
        return this.value;
    }

    @Override
    public Property<K, Boolean> update(Object value) {

        if(!(value instanceof Boolean)) {
            throw new IllegalArgumentException("The value must be a Boolean.");
        }

        this.value = Optional.of((Boolean) value);

        return this;

    }
}
