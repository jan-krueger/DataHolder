import de.SweetCode.DataHolder.Property.Property;

import java.util.Optional;

/**
 * Created by Yonas on 16.09.2015.
 */
public class ExampleProperty implements Property<String, String> {

    @Override
    public String getKey() {
        return "ExampleProperty";
    }

    @Override
    public Optional<String> get() {
        return Optional.of("Example Property Value");
    }

}