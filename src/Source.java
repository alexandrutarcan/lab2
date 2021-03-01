abstract public class Source {
    protected String name;
    // private SourceType type;
    /*
     * Constructor with 2 parameters
     public Source(String name, SourceType type) {
        this.name = name;
        // this.type = type;
    }*/
    public Source(){}
    /**
     * constructor with 1 parameter
     *
     * @param name
     */
    public Source(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //   public SourceType getType() {
    //       return type;
    //    }

    public void setName(String name) {
        this.name = name;
    }

    //  public void setType(SourceType type) {
    //     this.type = type;
    //   }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                '}';
    }

}
