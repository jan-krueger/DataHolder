/**
 * Created by Yonas on 16.09.2015.
 */

import de.SweetCode.DataHolder.DataHolder;
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

}
