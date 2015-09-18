package de.SweetCode.DataHolder.Property.properties;

import de.SweetCode.DataHolder.Property.Property;

import java.util.Optional;

/**
 * Created by Yonas on 18.09.2015.
 */
public class DoubleProperty<K> implements Property<K, Double> {

    private K key;
    private Optional<Double> value;

    public DoubleProperty(K key, Optional<Double> value) {
        this.key = key;
        this.value = value;
    }

    public DoubleProperty(K key, double value) {
        this(key, Optional.of(value));
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public Optional<Double> get() {
        return this.value;
    }

}
