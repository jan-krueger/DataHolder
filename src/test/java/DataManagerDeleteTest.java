
import de.SweetCode.DataHolder.DataCarriers.DataHolder;
import de.SweetCode.DataHolder.Property.properties.IntegerProperty;
import de.SweetCode.DataHolder.Property.properties.StringProperty;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Yonas on 20.09.2015.
 */
public class DataManagerDeleteTest extends TestCase {

    @Test
    public void testSingleObjectPropertyDelete() {

        DataHolder dataHolder = new DataHolder();

        StringProperty<String> objectA = new StringProperty<String>("A", "Yonas");
        dataHolder.store(objectA);

        StringProperty<String> objectB = new StringProperty<String>("B", "Felix");
        dataHolder.store(objectB);


        StringProperty<String> deletedProperty = dataHolder.deleteProperty(objectA).get();

        Assert.assertEquals(
                "Deleted Property is null, should be a StringProperty.",
                true,
                (!(deletedProperty == null))
        );

        Assert.assertEquals(
                "Property hasn't been removed.",
                true,
                (dataHolder.size() == 1)
        );

    }

    @Test
    public void testSingleClassAndKeyPropertyDelete() {

        DataHolder dataHolder = new DataHolder();

        StringProperty<String> objectA = new StringProperty<String>("A", "Yonas");
        dataHolder.store(objectA);

        StringProperty<String> objectB = new StringProperty<String>("B", "Felix");
        dataHolder.store(objectB);


        StringProperty<String> deletedProperty = dataHolder.deleteProperty(StringProperty.class, "A").get();

        Assert.assertEquals(
                "Deleted Property is null, should be a StringProperty.",
                true,
                (!(deletedProperty == null))
        );

        Assert.assertEquals(
                "Property hasn't been removed.",
                true,
                (dataHolder.size() == 1)
        );

    }

    @Test
    public void testMultiObjectPropertyDelete() {

        DataHolder dataHolder = new DataHolder();

        StringProperty<String> objectA = new StringProperty<String>("A", "Yonas");
        dataHolder.store(objectA);

        StringProperty<String> objectB = new StringProperty<String>("B", "Felix");
        dataHolder.store(objectB);

        IntegerProperty<String> objectC = new IntegerProperty<String>("Money", 14);
        dataHolder.store(objectC);


        List<StringProperty> deletedList =  dataHolder.deleteProperties(StringProperty.class);

        Assert.assertEquals(
                String.format("Amount of deleted Properties is wrong. %d instead of 2.", deletedList.size()),
                true,
                (deletedList.size() == 2)
        );

        Assert.assertEquals(
                "Removed not only the expected Properties.",
                true,
                (dataHolder.size() == 1)
        );

    }

}
