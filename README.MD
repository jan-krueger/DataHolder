# DataHolder ![https://travis-ci.org/sweetcode/DataHolder](https://api.travis-ci.org/sweetcode/DataHolder.svg)
---
DataHolder is a simple project to provide a easy-to-use data storage solution.
You will find some examples of the usage below.

#### [Latest Release](https://github.com/sweetcode/DataHolder/releases/latest) | [All Releases](https://github.com/sweetcode/DataHolder/releases/)

---
#### Basic Usage
```java
import de.SweetCode.DataHolder.DataCarrier.DataHolder;

public class PlayerData extends DataHolder {

    public PlayerData() {}

}
```

Thats it. You have a working DataHolder now.

---
### Property Class
To create your own Property class you just have to implement the `Property interface`.
The interface contains three methods `K getKey()`, `Optional<V> get()` and `Property<K, V> update(Object value)`.

Below you can find a simple example how it works:

```java
import de.SweetCode.DataHolder.Property.Property;

public class ExampleProperty implements Property<String, Double> {

    private String key;
    private Optional<Double> value;

    public ExampleProperty(String key, double value) {

        this.key = key;
        this.double = Optional.of(value);

    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public Optional<Double> get() {
        return this.value;
    }

    @Override
    public Property<K, V> update(Object value) {

        if(!(value instanceof Double)) {
            return null;
        }

        this.value = Optional.of((Double) value);

        return this;
    }

}
```
---
#### Store Method
This method allows you to store a Property. The project already contains for all
java primitive data types (String, Integer, Boolean etc.) a basic Property class.
```java
PlayerData player = new PlayerData();

player.store(new ExampleProperty("Money", 1200.5));
player.store(new ExampleProperty("Health", 12));
```

#### Get Property/Properties
This method returns the first Property, all Properties of the same kind or a Property related to a key.

```java
ExampleProperty property = player.getProperty(ExampleProperty.class, "Money");
System.out.println(property.getKey() + " => " + property.get().get());
```
This code writes into your console `Money => 1200.5`.
And this is how you get all of the stored Properties of the same kind.
```java
List<ExampleProperty> properties = player.getProperties(ExampleProperty.class);

for(ExampleProperty entry : properties) {
    System.out.println(entry.getKey() + " => " + entry.get().get());
}

```

This code writes into your console.
```
Money => 1200.5
Health => 12
```
---
### Delete Property/Properties
To delete all Properties of the same kind is really easy.
```java
player.deleteProperties(ExampleProperty.class);
```
This would delete all Properties of the kind ExampleProperty.

It's also really easy to delete a Property based on the type and key.
```java
player.deleteProperty(ExampleProperty.class, "A");
```
---
### Store all kind of Properties
This is the main advantage. You can store all kind of Properties in the DataHolder it only has to be a Property everything else is up to you.

```java
player.store(new BooleanProperty<String>("online", true));
player.store(new StringProperty<String>("homepage", "http://example.org"));
```
