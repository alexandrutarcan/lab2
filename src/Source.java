public class Source {
    private String name;
    private SourceType type;
    private int supply;

    /**
     * Constructor with 2 parameters
     *
     * @param name
     * @param type
     */
    public Source(String name, SourceType type) {
        this.name = name;
        this.type = type;
    }

    public Source(String name, SourceType type, int supply) {
        this.name = name;
        this.type = type;
        this.supply = supply;
    }

    public Source(String name, int supply) {
        this.name = name;
        this.supply = supply;
    }

    /**
     * constructor with 1 parameter
     *
     * @param name
     */
    public Source(String name) {
        this.name = name;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    public String getName() {
        return name;
    }

    public SourceType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", supply=" + supply +
                '}';
    }
}
