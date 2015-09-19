import de.SweetCode.DataHolder.DataHolder;
import de.SweetCode.DataHolder.Property.properties.BooleanProperty;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * Created by Yonas on 19.09.2015.
 */
public class DataManagerExceptionTest extends TestCase {

    @Test(expected = NoSuchElementException.class)
    public void testExceptionIfYouTryToAccessANonExistingData() {

        DataHolder dataHolder = new DataHolder();
        dataHolder.getProperty(BooleanProperty.class).get();

    }


}
