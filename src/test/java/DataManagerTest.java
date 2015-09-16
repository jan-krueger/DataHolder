/**
 * Created by Yonas on 16.09.2015.
 */

import de.SweetCode.DataHolder.DataHolder;
import junit.framework.TestCase;
import org.junit.Assert;

public class DataManagerTest extends TestCase {

    private DataHolder dataHolder = new DataHolder();

    public DataManagerTest() {
        super("DataManagerTest");
    }

    public void testDefaultObject() {

        Assert.assertEquals(
                "Unexpected properties stored in the default DataHolder.",
                true,
                this.dataHolder.getProperties().isEmpty()
        );

    }

    public void testStoringObject() {

        this.dataHolder.store(new ExampleProperty());

        Assert.assertEquals(
                "Couldn't store the Property.",
                true,
                this.dataHolder.getProperty(ExampleProperty.class).get().get().isPresent()
        );

    }

    public void testIfTheExampleIsStillStored() {

        Assert.assertEquals(
                "Property isn't stored.",
                "Example Property Value",
                this.dataHolder.getProperty(ExampleProperty.class).get().get().get()
        );

    }

    public void testStoredPropertyTypes() {

        Assert.assertEquals(
                "Couln't return all Property types.",
                true,
                (this.dataHolder.getPropertieTypes().size() == 1)
        );

    }

}
