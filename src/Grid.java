import java.util.HashSet;
import java.util.Set;

public class Grid {

    private final int rows;
    private final int columns;
    private final Set<Position> aliveCells; //stocke uniquement que les cellules vivantes


    private static final int DEFAULT_SIZE = 50;




    // Constructeur
    public Grid(int rows, int columns, Set<Position> aliveCells) throws InvalidGridSizeException, PositionOutOfBoundsException {
        // Vérification de la taille de la grille
        if (rows <= 0 || columns <= 0) {
            throw new InvalidGridSizeException("La taille de la grille est invalide.");
        }

        this.rows = rows;
        this.columns = columns;
        this.aliveCells = new HashSet<>();

        // Ajout des cellules vivantes à la grille
        for (Position pos : aliveCells) {
            if (!isValidPosition(pos)) {
                throw new PositionOutOfBoundsException("La position (" + pos.getRow() + ", " + pos.getColumn() + ") est en dehors de la grille.");
            }
            this.aliveCells.add(pos);
        }
    }


    //méthode pour vérif la pos si elle est valide
    private boolean isValidPosition(Position pos){
        return pos.getRow() >= 0 && pos.getRow() < rows && pos.getColumn() >= 0 && pos.getColumn() < columns;
    }


    public int getRows() {return rows;}
    public int getColumns() {return columns;}



    // avoir l'état de la cellule
    // public boolean getCellStateAt(Position pos) {return alive.Cells.contains(pos); }
    public boolean getCellStateAt(Position pos) {
        if (isValidPosition(pos)){
            return aliveCells.contains(pos); //si la pos est dans set alors cellule vivante

        }return false; //hors de la grille => cellule morte
    }

    // modifier état de la cellule
    public void setCellStateAt(Position pos, boolean isAlive) throws PositionOutOfBoundsException {
        if (!isValidPosition(pos)) {
            throw new PositionOutOfBoundsException("Position hors des limites.");
        }
        if (isAlive) {
            aliveCells.add(pos);
        } else {
            aliveCells.remove(pos);
        }
    }

    // avoir le nombre de cellule vivante
    public int getAliveCellCount() {
        return aliveCells.size();
    }

    //methode qui retounre un Set de toutes les positions des cellules vivantes
    public Set<Position> getAliveCells() {
        return new HashSet<>(aliveCells);
    }

    // Méthode toString pour une représentation en Ascii-Art de la grille
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Position pos = new Position(i, j);
                sb.append(aliveCells.contains(pos) ? "*" : "."); // Cellule vivante => "*", Cellule morte => "."
            }
            sb.append("\n"); // Nouvelle ligne après chaque rangée
        }
        return sb.toString();
    }


}

