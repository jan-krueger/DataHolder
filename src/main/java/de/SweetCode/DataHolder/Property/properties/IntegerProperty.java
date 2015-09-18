package de.SweetCode.DataHolder.Property.properties;

import de.SweetCode.DataHolder.Property.Property;

import java.util.Optional;

/**
 * Created by Yonas on 18.09.2015.
 */
public class IntegerProperty<K> implements Property<K, Integer> {

    private K key;
    private Optional<Integer> value;

    public IntegerProperty(K key, Optional<Integer> value) {
        this.key = key;
        this.value = value;
    }

    public IntegerProperty(K key, int value) {
        this(key, Optional.of(value));
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public Optional<Integer> get() {
        return this.value;
    }

}
