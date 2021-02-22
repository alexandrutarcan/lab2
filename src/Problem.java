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

    /**
     * the cost matrix of transport
     */
    int costsMatrix[][];

    /**
     * constructor with 3 parameters
     * @param sources  which supply the commodities
     * @param destinations which demand the commodities
     * @param costsMatrix the cost matrix of transport
     */
    public Problem(Source[] sources, Destination[] destinations, int[][] costsMatrix) {
        this.sources = sources;
        this.destinations = destinations;
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
                "sources=" + Arrays.toString(sources) + '\n' +
                ", destinations=" + Arrays.toString(destinations) + '\n'+
                ", costsMatrix=" + '\n' + matrix +'\n'+
                '}';
    }

    public static void main(String[] args) {

        /**
         *  instantiated 3 objects from Source class
         */
        Source s1 = new Source("S1", SourceType.FACTORY,10);
        Source s2 = new Source("S2", SourceType.WAREHOUSE,35);
        Source s3 = new Source("S3", SourceType.WAREHOUSE,25);

        System.out.println(s1);
        /**
         * populated an array of sources
         */
        Source[] sources = new Source[3];
        sources[0] = s1;
        sources[1] = s2;
        sources[2] = s3;

        /**
         *  instantiated 3 objects from Destination class
         */
        Destination d1=new Destination("D1",20);
        Destination d2=new Destination("D2",25);
        Destination d3=new Destination("D3",25);

        /**
         * populated an array of destinations
         */
        Destination[] destinations=new Destination[3];
        destinations[0]=d1;
        destinations[1]=d2;
        destinations[2]=d3;

        /**
         * declare and instantiate a matrix of costs
         */
        int[][] costsMatrix={{2,3,1},{5,4,8},{5,6,8}};

        /**
         * create an instance of Problem class(given in the lab2)
         */
        Problem transportationProblem=new Problem(sources,destinations,costsMatrix);
        System.out.println(transportationProblem);

    }
}
