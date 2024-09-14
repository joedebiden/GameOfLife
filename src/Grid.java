import java.util.Set;

public class Grid {

    private final int rows;
    private final int columns;
    private final boolean [][] grid;

    private static final int DEFAULT_SIZE = 50;




    // Constructeur
    public Grid(int rows, int columns, Set<Position> aliveCells) throws InvalidGridSizeException, PositionOutOfBoundsException {
        // Vérification de la taille de la grille
        if (rows <= 0 || columns <= 0) {
            throw new InvalidGridSizeException("La taille de la grille est invalide.");
        }

        this.rows = rows;
        this.columns = columns;
        this.grid = new boolean[rows][columns];

        // Ajout des cellules vivantes à la grille
        for (Position pos : aliveCells) {
            if (pos.getRow() < 0 || pos.getRow() >= rows || pos.getColumn() < 0 || pos.getColumn() >= columns) {
                throw new PositionOutOfBoundsException("La position (" + pos.getRow() + ", " + pos.getColumn() + ") est en dehors de la grille.");
            }
            grid[pos.getRow()][pos.getColumn()] = true;
        }
    }


    //méthode pour vérif la pos si elle est valide
    private boolean isValidPosition(Position pos){
        return pos.getRow() >= 0 && pos.getRow() < rows && pos.getColumn() >= 0 && pos.getColumn() < columns;
    }


    public int getRows() {return rows;}
    public int getColumns() {return columns;}



    // avoir l'état de la cellule
    public boolean getCellStateAt(Position pos) {
        if (isValidPosition(pos)){
            return grid[pos.getRow()][pos.getColumn()];

        }return false; //hors de la grille => cellule morte
    }

    public void setCellStateAt(Position pos, boolean isAlive) {
        if (isValidPosition(pos)) {
            grid[pos.getRow()][pos.getColumn()] = isAlive;
        }
    }



    // avoir le nombre de cellule vivante
    public int getAliveCellCount() {
        int count = 0;
        for (int i = 0; i < rows; i ++ ) {
            for (int j = 0; j < columns; j ++) {
                if (grid[i][j]) {
                    count++;
                }
            }
        } return count;
    }

    // Méthode toString pour une représentation en Ascii-Art de la grille
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sb.append(grid[i][j] ? "*" : "."); // Cellule vivante => "*", Cellule morte => "."
            }
            sb.append("\n"); // Nouvelle ligne après chaque rangée
        }
        return sb.toString();
    }


}

