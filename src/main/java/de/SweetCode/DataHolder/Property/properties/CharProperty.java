package de.SweetCode.DataHolder.Property.properties;

import de.SweetCode.DataHolder.Property.Property;

import java.util.Optional;

/**
 * Created by Yonas on 18.09.2015.
 */
public class CharProperty<K> implements Property<K, Character> {

    private K key;
    private Optional<Character> value;

    public CharProperty(K key, Optional<Character> value) {
        this.key = key;
        this.value = value;
    }

    public CharProperty(K key, char value) {
        this(key, Optional.of(value));
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public Optional<Character> get() {
        return this.value;
    }

    @Override
    public Property<K, Character> update(Object value) {

        if(!(value instanceof Character)) {
            throw new IllegalArgumentException("The value must be a Character.");
        }

        this.value = Optional.of((Character) value);

        return this;

    }

}
