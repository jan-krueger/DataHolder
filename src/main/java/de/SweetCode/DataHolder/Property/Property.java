package de.SweetCode.DataHolder.Property;

import java.util.Optional;

/**
 * Created by Yonas on 15.09.2015.
 */
public interface Property<K, V> {

    /**
     * The key of the property.
     * @return
     */
    K getKey();

    /**
     * Returns a optional with the value.
     * @return
     */
    Optional<V> get();

}
