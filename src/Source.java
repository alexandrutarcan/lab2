abstract public class Source {
    //name of the source
    protected String name;
    // private SourceType type;
    /*
     * Constructor with 2 parameters
     public Source(String name, SourceType type) {
        this.name = name;
        // this.type = type;
    }*/

    /**
     * constructor withoutparameter
     */
    public Source() {
    }

    /**
     * constructor with 1 parameter
     *
     * @param name - the name of the source
     */
    public Source(String name) {
        this.name = name;
    }

    /**
     * get the name value of the instance
     */
    public String getName() {
        return name;
    }

    /**
     * set the name value of the instance
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * override toString() method from Object class
     * @return the identity of the object in a formatted string value, including name value
     */
    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                '}';
    }

}
