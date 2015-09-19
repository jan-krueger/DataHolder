package de.SweetCode.DataHolder.Property;

/**
 * Created by Yonas on 19.09.2015.
 */
public interface PropertySerializable<T> {

    String serialize();

    T unserialize(String data);

}
