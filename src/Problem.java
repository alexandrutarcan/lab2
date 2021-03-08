import java.util.Arrays;

public class Problem {

    /**
     * sources which supply the commodities
     */
    Source[] sources;

    /**
     * destinations which demand the commodities
     */
    Destination[] destinations;
    private int supply[];
    private int demand[];

    /**
     * the cost matrix of transport
     */
   private int costsMatrix[][];


    /**
     * constructor with 5 parameters
     *
     * @param sources      which supply the commodities
     * @param destinations which demand the commodities
     * @param costsMatrix  the cost matrix of transport
     * @param supply
     * @param demand
     */
    public Problem(Source[] sources, int[] supply, Destination[] destinations, int[] demand, int[][] costsMatrix) {
        this.sources = sources;
        this.destinations = destinations;
        this.costsMatrix = costsMatrix;
        this.supply = supply;
        this.demand = demand;
    }

    /**
     * get sources which supply the commodities
     * @return an array of sources
     */
    public Source[] getSources() {
        return sources;
    }
    /**
     * set sources which supply the commodities
     */
    public void setSources(Source[] sources) {
        this.sources = sources;
    }
    /**
     * get destinations which demand the commodities
     */
    public Destination[] getDestinations() {
        return destinations;
    }
    /**
     * set destinations which demand the commodities
     */
    public void setDestinations(Destination[] destinations) {
        this.destinations = destinations;
    }
    /**
     * get quantities supplied
     */
    public int[] getSupply() {
        return supply;
    }
    /**
     * set a quantity to supply
     */
    public void setSupplyElement(int position, int value) {
        this.supply[position] = value;
    }
    /**
     * set a quantity to demand
     */
    public void setDemandElement(int position, int value) {
        this.demand[position] = value;
    }
    /**
     * get demanded quantities
     */
    public int[] getDemand() {
        return demand;
    }

    /**
     * get the matrix of cost to transport the quantities from sources to destinations
     * @return
     */
    public int[][] getCostsMatrix() {
        return costsMatrix;
    }

    /**
     * @return cost matrix in a formatted string
     */
    @Override
    public String toString() {
        String matrix = "";
        for (int i = 0; i < costsMatrix.length; i++) {
            matrix += Arrays.toString(costsMatrix[i]) + '\n';
        }
        return "Problem{" + '\n' +
                "sources=" + Arrays.toString(sources) +
                "\nsupply=" + Arrays.toString(supply) +
                ", \ndestinations=" + Arrays.toString(destinations) +
                "\ndemand=" + Arrays.toString(demand) +
                ",\ncostsMatrix=" + '\n' + matrix + '\n' +
                '}';
    }

    /**
     * test if the sum of supplies is equal with the sum of demands
     * @return
     */
    public boolean isBalanced() {
        int supplies = 0;
        for (int s : supply) {
            supplies += s;
        }
        for (int d : demand) {
            supplies -= d;
        }
        if (supplies != 0)
            return false;
        return true;
    }
}
