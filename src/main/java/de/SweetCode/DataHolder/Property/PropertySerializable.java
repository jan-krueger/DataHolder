package de.SweetCode.DataHolder.Property;

/**
 * Created by Yonas on 19.09.2015.
 */
public interface PropertySerializable<K, V, T> extends Property<K, V> {

    /**
     * The serialized data.
     * @return
     */
    T serialize();

}
