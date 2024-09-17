import java.util.HashSet;
import java.util.Set;

public class GameOfLife {

    private Grid grid;
    private int iterations;
    private static final int  DEFAULT_ITERATIONS = 100;

    private final Display display;

    public GameOfLife(Grid grid, int interations, Display display) {
        this.grid = grid;
        //si iterations est incohérent alors valeurs par défaut
        this.iterations = (interations > 0) ? interations : DEFAULT_ITERATIONS;
        this.display = display;
        display.notifyNewSimulation(iterations, grid.getRows(), grid.getColumns());
    }

    //methode pour exécuter la simulation
    public void execute() {
        for (int i = 0; i < iterations; i ++ ) {
            Set<Position> aliveCells = grid.getAliveCellCount();
            display.notifyNewGeneration(i, aliveCells);
            grid = calculateNextGeneration();
        }
    }

    // Méthode privée pour calculer la prochaine génération de la grille
    private Grid calculateNextGeneration() throws InvalidGridSizeException, PositionOutOfBoundsException{

        Set<Position> nextAliveCells = new HashSet<>();  // Ensemble pour les cellules vivantes de la prochaine génération

        for (int row = 0; row < grid.getRows(); row++) {
            for (int col = 0; col < grid.getColumns(); col++) {
                Position pos = new Position(row, col);
                boolean isAlive = grid.getCellStateAt(pos);
                int aliveNeighbors = countAliveNeighbors(pos);

                // Règles du jeu de la vie :
                // 1. Une cellule vivante reste vivante si elle a 2 ou 3 voisins vivants, sinon elle meurt.
                // 2. Une cellule morte devient vivante si elle a exactement 3 voisins vivants.
                if ((isAlive && (aliveNeighbors == 2 || aliveNeighbors == 3)) ||
                        (!isAlive && aliveNeighbors == 3)) {
                    nextAliveCells.add(pos);  // Ajouter la position à l'ensemble des cellules vivantes
                }
            }
        }
        // Créer la nouvelle grille avec les cellules vivantes calculées
        return new Grid(grid.getRows(), grid.getColumns(), nextAliveCells);
    }

    // Méthode pour compter le nombre de cellules vivantes voisines d'une position donnée
    private int countAliveNeighbors(Position pos) {
        int count = 0;
        // Parcours des 8 directions
        for (Direction dir : Direction.values()) {
            Position neighborPos = pos.getNeighbor(dir);
            if (grid.getCellStateAt(neighborPos)) {
                count++;
            }
        }
        return count;
    }



}
