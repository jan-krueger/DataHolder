package de.SweetCode.DataHolder.Property.properties;

import de.SweetCode.DataHolder.Property.Property;

import java.util.Optional;

/**
 * Created by Yonas on 18.09.2015.
 */
public class ShortProperty<K> implements Property<K, Short> {

    private K key;
    private Optional<Short> value;

    public ShortProperty(K key, Optional<Short> value) {
        this.key = key;
        this.value = value;
    }

    public ShortProperty(K key, short value) {
        this(key, Optional.of(value));
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public Optional<Short> get() {
        return this.value;
    }

}
