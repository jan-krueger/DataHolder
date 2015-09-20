package de.SweetCode.DataHolder.Property.properties;

import de.SweetCode.DataHolder.Property.Property;

import java.util.Optional;

/**
 * Created by Yonas on 18.09.2015.
 */
public class FloatProperty<K> implements Property<K, Float> {

    private K key;
    private Optional<Float> value;

    public FloatProperty(K key, Optional<Float> value) {
        this.key = key;
        this.value = value;
    }

    public FloatProperty(K key, float value) {
        this(key, Optional.of(value));
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public Optional<Float> get() {
        return this.value;
    }

    @Override
    public Property<K, Float> update(Object value) {

        if(!(value instanceof Float)) {
            throw new IllegalArgumentException("The value must be a Float.");
        }

        this.value = Optional.of((Float) value);

        return this;

    }

}
