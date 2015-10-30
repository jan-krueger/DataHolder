import de.SweetCode.DataHolder.Property.Property;
import de.SweetCode.DataHolder.Property.PropertySerializable;
import de.SweetCode.DataHolder.utils.Optional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yonas on 20.09.2015.
 */
public class ExampleSerializableProperty<S, I, S1> implements PropertySerializable<String, Integer, String> {

    private String key;
    private Optional<Integer> value;

    public ExampleSerializableProperty(String key, Integer value) {
        this.key = key;
        this.value = Optional.of(value);
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public Optional<Integer> getValue() {
        return this.value;
    }

    @Override
    public Property<String, Integer> update(Object value) {

        if(!(value instanceof Integer)) {
            throw new IllegalArgumentException("The value must be a Integer.");
        }

        this.value = Optional.of((Integer) value);

        return this;

    }

    /**
     * This is just a simple implementation. You can do it on your own (such as this example) or you can use a lib to serialize the data (like: gson).
     */
    @Override
    public String serialize() {
        return String.format(
                "{\"key\":%s,\"value\":%d}",
                this.getKey(),
                this.getValue().get()
        );
    }

    /**
     * This isn't the best way but it's just a simple example for the unit test.
     */
     public static ExampleSerializableProperty<String, Integer, String> unserialize(String data) {

        Pattern re = Pattern.compile("(?:,|\\{)?([^:]*):(\"[^\"]*\"|\\{[^}]*\\}|[^},]*)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = re.matcher(data);

        String key = null;
        int value = 0;

        while (matcher.find()) {

            if(matcher.group(1).equalsIgnoreCase("\"key\"")) {
                key = matcher.group(2);
                continue;
            }

            if(matcher.group(1).equalsIgnoreCase("\"value\"")) {
                value = Integer.valueOf(matcher.group(2));
                continue;
            }

        }

        return new ExampleSerializableProperty<>(key, value);
    }

}
