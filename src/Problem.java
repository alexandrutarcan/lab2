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
    int costsMatrix[][];

    public Problem(){}

    /**
     * constructor with 5 parameters
     * @param sources  which supply the commodities
     * @param destinations which demand the commodities
     * @param costsMatrix the cost matrix of transport
     * @param supply
     * @param demand
     */
    public Problem(Source[] sources, int[] supply, Destination[] destinations, int[] demand, int[][] costsMatrix) {
        this.sources = sources;
        this.destinations = destinations;
        this.costsMatrix = costsMatrix;
        this.supply=supply;
        this.demand=demand;
    }

    public Source[] getSources() {
        return sources;
    }

    public void setSources(Source[] sources) {
        this.sources = sources;
    }

    public Destination[] getDestinations() {
        return destinations;
    }

    public void setDestinations(Destination[] destinations) {
        this.destinations = destinations;
    }

    public int[] getSupply() {
        return supply;
    }

    public void setSupply(int[] supply) {
        this.supply = supply;
    }

    public int[] getDemand() {
        return demand;
    }

    public void setDemand(int[] demand) {
        this.demand = demand;
    }

    public int[][] getCostsMatrix() {
        return costsMatrix;
    }

    public void setCostsMatrix(int[][] costsMatrix) {
        this.costsMatrix = costsMatrix;
    }

    /**
     *
     * @return cost matrix in a formatted string
     */
    @Override
    public String toString() {
        String matrix="";
        for(int i=0;i<costsMatrix.length;i++)
        {
            matrix+=Arrays.toString(costsMatrix[i])+ '\n';
        }
        return "Problem{" + '\n' +
                "sources=" + Arrays.toString(sources) +
                "\nsupply="+Arrays.toString(supply)+
                ", \ndestinations=" + Arrays.toString(destinations) +
                "\ndemand="+Arrays.toString(demand)+
                ",\ncostsMatrix=" + '\n' + matrix +'\n'+
                '}';
    }

    public boolean isBalanced(){
        if(demand.length!=supply.length)
            return  false;
        int supplies=0;
        for(int s:supply){
            supplies+=s;
        }
        for(int d:demand)
        {
            supplies-=d;
        }
        if(supplies!=0)
            return false;
        return true;
    }
}
