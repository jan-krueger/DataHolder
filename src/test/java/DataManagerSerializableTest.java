import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Yonas on 20.09.2015.
 */
public class DataManagerSerializableTest {

    @Test
    public void testSerializable() {

        ExampleSerializableProperty<String, Integer, String> exampleSerializableProperty = new ExampleSerializableProperty<>("Money", 5);

        String serialized = exampleSerializableProperty.serialize();

        Assert.assertEquals(
                "Serialize function doesn't return the expected JSON string.",
                "{\"key\":Money,\"value\":5}",
                serialized
        );

        ExampleSerializableProperty<String, Integer, String> unserializedPropety = ExampleSerializableProperty.unserialize(serialized);
        Assert.assertEquals(
                "Unserialized ExampleSerializableProperty doesn't contain the expected data.",
                true,
                (unserializedPropety.getKey().equals("Money") && unserializedPropety.get().get() == 5)
        );

    }

}
