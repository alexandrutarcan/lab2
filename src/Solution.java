import java.util.Arrays;

/**
 * class that represents a solution to a problem
 */
public class Solution {
    /**
     * the matrix in which is stored the quantities supplied by each source to each destination
     */
    private int[][] x;
    Problem problem;

    /**
     * Constructor with one parameter
     * @param problem - contains the data of the problem
     */
    public Solution(Problem problem){
        this.problem=problem;
    }

    /**
     * get the matrix with the quantities results
     */
    public int[][] getX() {
        return x;
    }
    /**
    * set the matrix with the quantities results
    */
    public void setX(int[][] x) {
        this.x = x;
    }
    /**
     * override toString() method from Object class
     * @return the identity of the object in a formatted string value
     */
    @Override
    public String toString() {
        String result= "Solution={" + '\n' ;
        for(int i=0;i<x.length;i++) {
            for (int j = 0; j < x[i].length; j++)
                result += x[i][j] + " ";
            result += '\n';
        }
        result+='}';
        return result;
    }

    /**
     * compute the cost of the solution
     * @return the value of total cost
     */
    public int computeCost()
    {
        int result=0;
        for(int i=0;i<x.length;i++)
            for(int j=0;j<x[i].length;j++){
                result+=x[i][j]*problem.getCostsMatrix()[i][j];
            }
        return result;
    }

}
