import java.util.Set;

public interface Display {
    void notifyNewSimulation(int iterations, int rows, int columns);
    void notifyNewGeneration(int generation, Set<Position> aliveCells);
}
