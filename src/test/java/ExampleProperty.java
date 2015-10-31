import de.SweetCode.DataHolder.Property.Property;
import de.SweetCode.DataHolder.utils.Optional;


/**
 * Created by Yonas on 16.09.2015.
 */
public class ExampleProperty implements Property<String, String> {

    @Override
    public String getKey() {
        return "ExampleProperty";
    }

    @Override
    public Optional<String> getValue() {
        return Optional.of("Example Property Value");
    }

    @Override
    public Property<String, String> update(String value) {

        return this;

    }

}
