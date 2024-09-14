public class GameOfLife {

    private Grid grid;
    private int iterations;
    private static final int  DEFAULT_ITERATIONS = 100;

    public GameOfLife(Grid grid, int interations) {
        this.grid = grid;
        //si iterations est incohérent alors valeurs par défaut
        this.iterations = (interations > 0) ? interations : DEFAULT_ITERATIONS;
    }

    //methode pour exécuter la simulation
    public void execute() {
        try {
            System.out.println("Début de la simulation du Jeu de la Vie");

            for (int i = 1; i <= iterations; i++) {
                System.out.println("Itération : " + i);
                System.out.println("Nombre de cellules vivantes : " + grid.getAliveCellCount());
                System.out.println(grid); // Affiche la grille sous forme d'ASCII Art

                // Calcul de la grille à la génération suivante
                grid = calculateNextGeneration();
            }

            System.out.println("Fin de la simulation");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Méthode privée pour calculer la prochaine génération de la grille
    private Grid calculateNextGeneration() {
        Grid nextGrid = new Grid(grid.getRows(), grid.getColumns());
        for (int row = 0; row < grid.getRows(); row++) {
            for (int col = 0; col < grid.getColumns(); col++) {
                Position pos = new Position(row, col);
                boolean isAlive = grid.getCellStateAt(pos);
                int aliveNeighbors = countAliveNeighbors(pos);

                // Règles du jeu de la vie :
                // 1. Une cellule vivante reste vivante si elle a 2 ou 3 voisins vivants, sinon elle meurt.
                // 2. Une cellule morte devient vivante si elle a exactement 3 voisins vivants.
                if (isAlive && (aliveNeighbors == 2 || aliveNeighbors == 3)) {
                    nextGrid.setCellStateAt(pos, true);
                } else if (!isAlive && aliveNeighbors == 3) {
                    nextGrid.setCellStateAt(pos, true);
                } else {
                    nextGrid.setCellStateAt(pos, false);
                }
            }
        }
        return nextGrid;
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
