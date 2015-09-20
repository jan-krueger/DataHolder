package de.SweetCode.DataHolder.Property;

/**
 * Created by Yonas on 19.09.2015.
 */
public interface PropertySerializable<T> {

    /**
     * The serialized data.
     * @return
     */
    T serialize();

}
