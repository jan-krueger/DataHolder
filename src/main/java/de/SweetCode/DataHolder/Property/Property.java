package de.SweetCode.DataHolder.Property;

import java.util.Optional;

/**
 * Created by Yonas on 15.09.2015.
 */
public interface Property<K, V> {

    K getKey();

    Optional<V> get();

}
