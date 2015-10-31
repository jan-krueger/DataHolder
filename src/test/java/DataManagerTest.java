/**
 * Created by Yonas on 16.09.2015.
 */

import de.SweetCode.DataHolder.DataCarriers.DataHolder;
import de.SweetCode.DataHolder.Property.properties.*;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.*;

public class DataManagerTest extends TestCase {

    public DataManagerTest() {
        super("DataManagerTest");
    }

    public void testDefaultObject() {

        DataHolder dataHolder = new DataHolder();

        assertEquals(
                "Unexpected properties stored in the default DataHolder.",
                true,
                dataHolder.getProperties().isEmpty()
        );

    }

    public void testStoringObject() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new ExampleProperty());

        assertEquals(
                "Couldn't store the Property.",
                true,
                dataHolder.getProperty(ExampleProperty.class, "ExampleProperty").get().getValue().isPresent()
        );

    }

    public void testBooleanProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new BooleanProperty<>("Boolean", true));

        assertEquals(
                "Default Property (Boolean) didn't store correctly.",
                true,
                dataHolder.getProperty(BooleanProperty.class, "Boolean").get().getValue().get().getClass().isAssignableFrom(Boolean.class)
        );

    }

    public void testByteProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new ByteProperty<>("Byte", (byte) 127));

        assertEquals(
                "Default Property (Byte) didn't store correctly.",
                true,
                dataHolder.getProperty(ByteProperty.class, "Byte").get().getValue().get().getClass().isAssignableFrom(Byte.class)
        );

    }

    public void testCharProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new CharProperty<>("Char", 'A'));

        assertEquals(
                "Default Property (Char) didn't store correctly.",
                true,
                dataHolder.getProperty(CharProperty.class, "Char").get().getValue().get().getClass().isAssignableFrom(Character.class)
        );

    }

    public void testDoubleProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new DoubleProperty<>("Double", Double.MAX_VALUE));

        assertEquals(
                "Default Property (Double) didn't store correctly.",
                true,
                dataHolder.getProperty(DoubleProperty.class, "Double").get().getValue().get().getClass().isAssignableFrom(Double.class)
        );

    }

    public void testFloatProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new FloatProperty<>("Float", Float.MAX_VALUE));

        assertEquals(
                "Default Property (Float) didn't store correctly.",
                true,
                dataHolder.getProperty(FloatProperty.class, "Float").get().getValue().get().getClass().isAssignableFrom(Float.class)
        );

    }

    public void testIntegerProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new IntegerProperty<>("Integer", Integer.MAX_VALUE));

        assertEquals(
                "Default Property (Integer) didn't store correctly.",
                true,
                dataHolder.getProperty(IntegerProperty.class, "Integer").get().getValue().get().getClass().isAssignableFrom(Integer.class)
        );

    }

    public void testLongProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new LongProperty<>("Long", Long.MAX_VALUE));

        assertEquals(
                "Default Property (Long) didn't store correctly.",
                true,
                dataHolder.getProperty(LongProperty.class, "Long").get().getValue().get().getClass().isAssignableFrom(Long.class)
        );

    }

    public void testShortProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new ShortProperty<>("Short", Short.MAX_VALUE));

        assertEquals(
                "Default Property (Short) didn't store correctly.",
                true,
                dataHolder.getProperty(ShortProperty.class, "Short").get().getValue().get().getClass().isAssignableFrom(Short.class)
        );

    }

    public void testStringProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new StringProperty<>("String", "Value"));

        assertEquals(
                "Default Property (String) didn't store correctly.",
                true,
                dataHolder.getProperty(StringProperty.class, "String").get().getValue().get().getClass().isAssignableFrom(String.class)
        );

    }

    public void testMapProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new MapProperty<>("Map", new HashMap()));

        assertEquals(
                "Default Property (Map) didn't store correctly.",
                true,
                dataHolder.getProperty(MapProperty.class, "Map").get().getValue().get().getClass().isAssignableFrom(HashMap.class)
        );

    }

    public void testListProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new ListProperty<>("List", new ArrayList()));

        assertEquals(
                "Default Property (List) didn't store correctly.",
                true,
                dataHolder.getProperty(ListProperty.class, "List").get().getValue().get().getClass().isAssignableFrom(ArrayList.class)
        );

    }

    public void testPropertyUpdateMethod() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new IntegerProperty<>("Integer", 42));

        assertEquals(
                "Property update method doesn't work.",
                50,
                dataHolder.getProperty(IntegerProperty.class, "Integer").get().update(50).getValue().get()
        );


        assertEquals(
                "DataHolder update method doesn't work.",
                true,
                dataHolder.updateProperty(IntegerProperty.class, "Integer", 100) && dataHolder.getProperty(IntegerProperty.class, "Integer").get().getValue().get() == 100
        );


    }

}
