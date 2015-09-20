/**
 * Created by Yonas on 16.09.2015.
 */

import de.SweetCode.DataHolder.DataHolder;
import de.SweetCode.DataHolder.Property.Property;
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

        Assert.assertEquals(
                "Unexpected properties stored in the default DataHolder.",
                true,
                dataHolder.getProperties().isEmpty()
        );

    }

    public void testStoringObject() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new ExampleProperty());

        Assert.assertEquals(
                "Couldn't store the Property.",
                true,
                dataHolder.getProperty(ExampleProperty.class, "ExampleProperty").get().isPresent()
        );

    }

    public void testBooleanProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new BooleanProperty<String>("Boolean", true));

        Assert.assertEquals(
                "Default Property (Boolean) didn't store correctly.",
                true,
                dataHolder.getProperty(BooleanProperty.class, "Boolean").get().get().getClass().isAssignableFrom(Boolean.class)
        );

    }

    public void testByteProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new ByteProperty<String>("Byte", (byte) 127));

        Assert.assertEquals(
                "Default Property (Byte) didn't store correctly.",
                true,
                dataHolder.getProperty(ByteProperty.class, "Byte").get().get().getClass().isAssignableFrom(Byte.class)
        );

    }

    public void testCharProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new CharProperty<String>("Char", 'A'));

        Assert.assertEquals(
                "Default Property (Char) didn't store correctly.",
                true,
                dataHolder.getProperty(CharProperty.class, "Char").get().get().getClass().isAssignableFrom(Character.class)
        );

    }

    public void testDoubleProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new DoubleProperty<String>("Double", Double.MAX_VALUE));

        Assert.assertEquals(
                "Default Property (Double) didn't store correctly.",
                true,
                dataHolder.getProperty(DoubleProperty.class, "Double").get().get().getClass().isAssignableFrom(Double.class)
        );

    }

    public void testFloatProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new FloatProperty<String>("Float", Float.MAX_VALUE));

        Assert.assertEquals(
                "Default Property (Float) didn't store correctly.",
                true,
                dataHolder.getProperty(FloatProperty.class, "Float").get().get().getClass().isAssignableFrom(Float.class)
        );

    }

    public void testIntegerProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new IntegerProperty<String>("Integer", Integer.MAX_VALUE));

        Assert.assertEquals(
                "Default Property (Integer) didn't store correctly.",
                true,
                dataHolder.getProperty(IntegerProperty.class, "Integer").get().get().getClass().isAssignableFrom(Integer.class)
        );

    }

    public void testLongProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new LongProperty<String>("Long", Long.MAX_VALUE));

        Assert.assertEquals(
                "Default Property (Long) didn't store correctly.",
                true,
                dataHolder.getProperty(LongProperty.class, "Long").get().get().getClass().isAssignableFrom(Long.class)
        );

    }

    public void testShortProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new ShortProperty<String>("Short", Short.MAX_VALUE));

        Assert.assertEquals(
                "Default Property (Short) didn't store correctly.",
                true,
                dataHolder.getProperty(ShortProperty.class, "Short").get().get().getClass().isAssignableFrom(Short.class)
        );

    }

    public void testStringProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new StringProperty<String>("String", "Value"));

        Assert.assertEquals(
                "Default Property (String) didn't store correctly.",
                true,
                dataHolder.getProperty(StringProperty.class, "String").get().get().getClass().isAssignableFrom(String.class)
        );

    }

    public void testMapProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new MapProperty<String>("Map", new HashMap()));

        Assert.assertEquals(
                "Default Property (Map) didn't store correctly.",
                true,
                dataHolder.getProperty(MapProperty.class, "Map").get().get().getClass().isAssignableFrom(HashMap.class)
        );

    }

    public void testListProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new ListProperty<String>("List", new ArrayList()));

        Assert.assertEquals(
                "Default Property (List) didn't store correctly.",
                true,
                dataHolder.getProperty(ListProperty.class, "List").get().get().getClass().isAssignableFrom(ArrayList.class)
        );

    }

    public void testPropertyUpdateMethod() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new IntegerProperty<String>("Integer", 42));

        Assert.assertEquals(
                "Moaip",
                true,
                dataHolder.getProperty(IntegerProperty.class, "Integer").update(43).getClass().isAssignableFrom(IntegerProperty.class)
        );

    }


}
