package de.SweetCode.DataHolder.Property.properties;

import de.SweetCode.DataHolder.Property.Property;

import java.util.Optional;

/**
 * Created by Yonas on 18.09.2015.
 */
public class StringProperty<K> implements Property<K, String> {

    private K key;
    private Optional<String> value;

    public StringProperty(K key, Optional<String> value) {
        this.key = key;
        this.value = value;
    }

    public StringProperty(K key, String value) {
        this(key, Optional.of(value));
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public Optional<String> get() {
        return this.value;
    }

}
