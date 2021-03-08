/**
 * a specific class of Algorithm that describe a Greedy Algorithm method for solving the Transportation problem
 */
public class GreedyAlgorithm extends Algorithm {
    Problem problem;

    /**
     * the constructor with one parameter
     * @param problem
     */
    public GreedyAlgorithm(Problem problem) {

        this.problem = problem;
    }

    /**
     * implements the solve of the algorithms from the parent
     * @return a Solution object with the results
     */
    public Solution solve() {
        //used to store cost differences by row
        int[] rowCostDif = new int[problem.getSupply().length];
        //used to store cost differences by column
        int[] columnCostDif = new int[problem.getDemand().length];
        for (int r : rowCostDif) {
            r = 0;
        }
        for (int c : columnCostDif) {
            c = 0;
        }
        int[][] matrix = new int[problem.getCostsMatrix().length][];
        matrix = problem.getCostsMatrix();
        //compute the transpus matrix
        int[][] matrixTranspus = new int[problem.getDemand().length][problem.getSupply().length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++) {
                matrixTranspus[j][i] = matrix[i][j];
            }
        //result cost matrix
        int[][] x = new int[problem.getSupply().length][problem.getDemand().length];
        if (problem.isBalanced()) {
            while (!isFinished(problem.getDemand())) {
                int maximRow = -1;
                int rowPosition = -1;
                int maximColumn = -1;
                int columnPosition = -1;
                //completez vectorul rowCostDif cu diferenta dintre primele 2 minime si
                //determin maximul in variabila maximRow
                //pastrez pozitia maximului
                for (int i = 0; i < matrix.length; i++) {
                    rowCostDif[i] = Math.abs(min(matrix[i]) - secondMin(matrix[i]));
                    if (rowCostDif[i] > maximRow) {
                        maximRow = rowCostDif[i];
                        rowPosition = i;
                    }

                }
                //completez vectorul columnCostDif cu diferenta dintre primele 2 minime si
                //determin maximul in variabila maximColumn
                //pastrez pozitia maximului
                for (int i = 0; i < matrixTranspus.length; i++) {
                    columnCostDif[i] = Math.abs(min(matrixTranspus[i]) - secondMin(matrixTranspus[i]));
                    if (columnCostDif[i] > maximColumn) {
                        maximColumn = columnCostDif[i];
                        columnPosition = i;
                    }
                }
                //aleg maximul dintre cele 2 pentru a identifica celula potrivita [xi][xj]
                int xi = -1, xj = -1;
                int minsol = Integer.MAX_VALUE;
                if (maximColumn > maximRow) {
                    xj = columnPosition;
                    for (int k = 0; k < matrixTranspus[columnPosition].length; k++) {
                        if (matrixTranspus[columnPosition][k]!=-1 && minsol > matrixTranspus[columnPosition][k]) {
                            minsol = matrixTranspus[columnPosition][k];
                            xi = k;
                        }
                    }
                    //x[xi][xj] = Math.min(problem.getSupply()[xj], problem.getDemand()[xi]);
                } else {
                    xi = rowPosition;
                    for (int k = 0; k < matrix.length; k++) {
                        if (matrix[rowPosition][k]!=-1 && minsol > matrix[rowPosition][k]) {
                            minsol = matrix[rowPosition][k];
                            xj = k;
                        }
                    }
                }
                //am identificat celula din matricea de costuri
                x[xi][xj] = Integer.min(problem.getSupply()[xi], problem.getDemand()[xj]);
                //trebuie sa actualize demand si supply
                if (problem.getSupply()[xi] > problem.getDemand()[xj]) {
                    problem.setSupplyElement(xi, problem.getSupply()[xi] - problem.getDemand()[xj]);
                    problem.setDemandElement(xj, 0);
                    // pun -1 pe coloana in matrix
                    for (int k = 0; k < matrix.length; k++) {
                        matrix[k][xj] = -1;
                        matrixTranspus[xj][k]=-1;
                    }
                } else {
                    problem.setDemandElement(xj, -problem.getSupply()[xi] + problem.getDemand()[xj]);
                    problem.setSupplyElement(xi, 0);
                    // pun -1 pe linie in matrix
                    for (int k = 0; k < matrix[xi].length; k++) {
                        matrix[xi][k] = -1;
                        matrixTranspus[k][xi]=-1;
                    }
                }

                //trebuie sa completez cu -1 pe linia corespunzatoare cantitatii minime dintre supply si demand
            }
        }
        Solution solution = new Solution(problem);
        solution.setX(x);
        return solution;
    }

    /**
     * implements the finished condition; when all demands are satisfied
     * @return true if all demands values are 0
     *          false if exist a demand unsatisfied
     */
    private boolean isFinished(int[] demand) {
        int contor = 0;
        for (int i = 0; i < demand.length; i++)
            if (demand[i] != 0)
                return false;
        return true;
    }
    /**
     * used to determine the minim valu in an array
     * @return the minim value
     */
    private int min(int[] array) {
        if (array.length == 0)
            return -1;
        int minim = array[0];
        for (int i : array) {
            if (i != -1 && minim > i)
                minim = i;
        }
        return minim;

    }

    /**
     * used to determine the second minim value in an array
     * @return the second minim value
     */
    private int secondMin(int[] array) {
        if (array.length == 0)
            return -1;
        int minim = min(array);
        int secondMinim = Integer.MAX_VALUE;
        for (int i : array) {
            if (i != -1 && secondMinim > i && i != minim)
                secondMinim = i;
        }
        return secondMinim;

    }

}
