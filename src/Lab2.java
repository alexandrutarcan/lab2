import java.util.Arrays;

public class Lab2 {
    public static boolean contains(Destination[] destinations, Destination destination ){
        for(int i=0;i< destinations.length;i++)
            if((destinations[i] != null) && (destinations[i].equals(destination)))
                return true;
        return false;
    }
    public static void addDestination(Destination d,Destination[] destinations, int position){
        if(!contains(destinations,d)){
            destinations[position]=d;
        }
    }

    public static void main(String[] args) {

        /**
         *  instantiated 3 objects from Source class
         */
        //Source s1 = new Source("S1", SourceType.FACTORY,10);
        Source s1=new Factory("S1");
        Source s2=new Warehouse("S2");
        Source s3=new Warehouse("S3");

       System.out.println(s1.getClass());
       System.out.println(s1);
        /**
         * populated an array of sources
         */
        Source[] sources = new Source[3];
        sources[0] = s1; //factory object
        sources[1] = s2; //warehouse object
        sources[2] = s3; //warehouse object

        /**
         *  instantiated 3 objects from Destination class
         */
        Destination d1=new Destination("D1");
        Destination d2=new Destination("D2");
        Destination d3=new Destination("D3");
        //Destination d4=new Destination("D4");

        /**
         * populated an array of destinations
         */
        Destination[] destinations=new Destination[4];
       addDestination(d1,destinations,0);
       addDestination(d1,destinations,1); //cannot add duplicates

       addDestination(d2,destinations,1);
       addDestination(d3,destinations,2);
      // addDestination(d4,destinations,3);


        /**
         * declare and instantiate a matrix of costs
         */
        //int[][] costsMatrix={{2,3,1},{5,4,8},{5,6,8}};
        int[][] costsMatrix={{3,1,7,4},{2,6,5,9},{8,3,3,2}};
        int[] supply={300,400,500};
        int[] demand={250,350,400,200};

        /**
         * create an instance of Problem class(given in the lab2)
         */
        Problem transportationProblem=new Problem(sources,supply, destinations, demand, costsMatrix);
        System.out.println(transportationProblem);
        System.out.println(transportationProblem.isBalanced());
        //Algorithm greedy = new GreedyAlgorithm(transportationProblem);
        GreedyAlgorithm greedy = new GreedyAlgorithm(transportationProblem);
        Solution sol = greedy.solve();
        System.out.println(sol);




    }
}
