abstract public class Algorithm {
    protected Problem problem;

    public Algorithm() {}

    public Algorithm(Problem problem) {
        this.problem = problem;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    abstract public Solution solve();
}
