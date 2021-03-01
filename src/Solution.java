import java.util.Arrays;

public class Solution {
    private int[][] x;

    public Solution(){}

    public int[][] getX() {
        return x;
    }

    public void setX(int[][] x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "x=" + Arrays.toString(x) +
                '}';
    }

    public int computeCost()
    {
        return 0;
    }

}
