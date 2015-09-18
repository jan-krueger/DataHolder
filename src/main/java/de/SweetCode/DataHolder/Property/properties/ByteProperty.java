package de.SweetCode.DataHolder.Property.properties;

import de.SweetCode.DataHolder.Property.Property;

import java.util.Optional;

/**
 * Created by Yonas on 18.09.2015.
 */
public class ByteProperty<K> implements Property<K, Byte> {

    private K key;
    private Optional<Byte> value;

    public ByteProperty(K key, Optional<Byte> value) {
        this.key = key;
        this.value = value;
    }

    public ByteProperty(K key, byte value) {
        this(key, Optional.of(value));
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public Optional<Byte> get() {
        return this.value;
    }

}
