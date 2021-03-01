public class GreedyAlgorithm extends Algorithm{
    Problem problem;

    public GreedyAlgorithm() {
    }

    public GreedyAlgorithm(Problem problem) {
        this.problem = problem;
    }

    public Solution solve(){

        Solution solution=new Solution();
        int[][] x=new int[problem.getSupply().length][problem.getDemand().length];
        int[] rowCostDif=new int[problem.getSupply().length];
        int[] columnCostDif= new int[problem.getDemand().length];
        for(int r:rowCostDif){
            r=0;
        }
        for(int c:columnCostDif){
            c=0;
        }
        int[][] matrix=problem.getCostsMatrix();
        int[][] matrixTranspus=new int[problem.getDemand().length][problem.getSupply().length];
        for(int i=0;i< matrix.length;i++)
            for(int j=0;j<matrix[i].length;j++){
                matrixTranspus[j][i]=matrix[i][j];
            }
        if(problem.isBalanced()) {
            while (!isFinished(matrix)) {
                int maximRow = -1;
                int rowPosition = -1;
                int maximColumn = -1;
                int columnPosition = -1;
                for (int i = 0; i < matrix.length; i++) {
                    rowCostDif[i] = Math.abs(min(matrix[i]) - secondMin(matrix[i]));
                    if (rowCostDif[i] > maximRow) {
                        maximRow = rowCostDif[i];
                        rowPosition = i;
                    }

                }
                for (int i = 0; i < matrixTranspus.length; i++) {
                    columnCostDif[i] = Math.abs(min(matrixTranspus[i]) - secondMin(matrixTranspus[i]));
                    if (columnCostDif[i] > maximColumn) {
                        maximColumn = columnCostDif[i];
                        columnPosition = i;
                    }
                }
                if (maximColumn > maximRow) {
                    int xj = columnPosition;
                    int maxsol = -1;
                    int xi = -1;
                    for (int k = 0; k < matrixTranspus[columnPosition].length; k++) {
                        if (maxsol < matrixTranspus[columnPosition][k]) {
                            maxsol = matrixTranspus[columnPosition][k];
                            xi = k;
                        }
                    }
                    x[xi][xj] = Math.min(problem.getSupply()[xj], problem.getDemand()[xi]);
                }
            }
        }
        return null;
    }

    public boolean isFinished(int[][] matrix){
        int contor=0;
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]!=-1)
                    contor++;
            }
        if(contor==2)
            return true;
        return false;
    }
    public int min(int[] array){
        if(array.length==0)
            return -1;
        int minim=array[0];
        for(int i:array)
        {
            if (minim>i)
                minim=i;
        }
        return minim;

    }

    public int secondMin(int[] array){
        if(array.length==0)
            return -1;
        int minim=min(array);
        int secondMinim=Integer.MAX_VALUE;
        for(int i:array)
        {
            if (secondMinim>i && i!=minim)
                secondMinim=i;
        }
        return secondMinim;

    }

}
