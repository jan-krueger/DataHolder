package de.SweetCode.DataHolder.Property.properties;

import de.SweetCode.DataHolder.Property.Property;

import java.util.Optional;

/**
 * Created by Yonas on 18.09.2015.
 */
public class LongProperty<K> implements Property<K, Long> {

    private K key;
    private Optional<Long> value;

    public LongProperty(K key, Optional<Long> value) {
        this.key = key;
        this.value = value;
    }

    public LongProperty(K key, long value) {
        this(key, Optional.of(value));
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public Optional<Long> get() {
        return this.value;
    }

}
