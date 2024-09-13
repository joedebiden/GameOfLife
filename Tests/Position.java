import java.util.Objects;

public class Position {

    private final int row;
    private final int column;

    // constructeur - permet de créer une instance dans la classe Position
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    //getter
    public int getRow() { return row; }
    public int getColumn() { return column;}

    @Override
    public String toString() {
        return "Position{" + "row=" + row + ", column=" + column + "}";
    }

    @Override //compare deux objets Position, vérif si l'obj est de type Position
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return row == position.row && column == position.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
