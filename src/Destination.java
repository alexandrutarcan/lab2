import java.util.Objects;

public class Destination {
    private String name;

    public Destination() {}
    public Destination(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * override toString() method from Object class
     * @return the identity of the object in a formatted string value, including name value
     */
    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                '}';
    }

    /**
     * override equals() method from Object class
     * @return true if the objects are equals by their names
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o; //cast de la Object la Destination
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
