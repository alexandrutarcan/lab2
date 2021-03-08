/**
 * abstraction of algorithm notion
 */
abstract public class Algorithm {
    /**
     * Data problem
     */
    protected Problem problem;

    public Algorithm() {}

    /**
     * method to implement to solve the problem
     * @return a solution specific to the problem
     */
    abstract public Solution solve();
}
