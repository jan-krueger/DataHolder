/**
 * Created by Yonas on 16.09.2015.
 */

import de.SweetCode.DataHolder.DataHolder;
import de.SweetCode.DataHolder.Property.properties.*;
import junit.framework.TestCase;
import org.junit.Assert;

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
                dataHolder.getProperty(ExampleProperty.class).get().get().isPresent()
        );

    }

    public void testBooleanProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new BooleanProperty<String>("Boolean", true));

        Assert.assertEquals(
                "Default Property (Boolean) didn't store correctly.",
                true,
                dataHolder.getProperty(BooleanProperty.class).get().get().get().getClass().isAssignableFrom(Boolean.class)
        );

    }

    public void testByteProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new ByteProperty<String>("Byte", (byte) 127));

        Assert.assertEquals(
                "Default Property (Byte) didn't store correctly.",
                true,
                dataHolder.getProperty(ByteProperty.class).get().get().get().getClass().isAssignableFrom(Byte.class)
        );

    }

    public void testCharProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new CharProperty<String>("Char", 'A'));

        Assert.assertEquals(
                "Default Property (Char) didn't store correctly.",
                true,
                dataHolder.getProperty(CharProperty.class).get().get().get().getClass().isAssignableFrom(Character.class)
        );

    }

    public void testDoubleProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new DoubleProperty<String>("Double", Double.MAX_VALUE));

        Assert.assertEquals(
                "Default Property (Double) didn't store correctly.",
                true,
                dataHolder.getProperty(DoubleProperty.class).get().get().get().getClass().isAssignableFrom(Double.class)
        );

    }

    public void testFloatProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new FloatProperty<String>("Float", Float.MAX_VALUE));

        Assert.assertEquals(
                "Default Property (Float) didn't store correctly.",
                true,
                dataHolder.getProperty(FloatProperty.class).get().get().get().getClass().isAssignableFrom(Float.class)
        );

    }

    public void testIntegerProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new IntegerProperty<String>("Integer", Integer.MAX_VALUE));

        Assert.assertEquals(
                "Default Property (Integer) didn't store correctly.",
                true,
                dataHolder.getProperty(IntegerProperty.class).get().get().get().getClass().isAssignableFrom(Integer.class)
        );

    }

    public void testLongProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new LongProperty<String>("Long", Long.MAX_VALUE));

        Assert.assertEquals(
                "Default Property (Long) didn't store correctly.",
                true,
                dataHolder.getProperty(LongProperty.class).get().get().get().getClass().isAssignableFrom(Long.class)
        );

    }

    public void testShortProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new ShortProperty<String>("Short", Short.MAX_VALUE));

        Assert.assertEquals(
                "Default Property (Short) didn't store correctly.",
                true,
                dataHolder.getProperty(ShortProperty.class).get().get().get().getClass().isAssignableFrom(Short.class)
        );

    }

    public void testStringProperty() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.store(new StringProperty<String>("String", "Value"));

        Assert.assertEquals(
                "Default Property (String) didn't store correctly.",
                true,
                dataHolder.getProperty(StringProperty.class).get().get().get().getClass().isAssignableFrom(String.class)
        );

    }


}
