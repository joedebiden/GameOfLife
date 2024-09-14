// Exception pour une position en dehors de la grille
public class PositionOutOfBoundsException extends Exception {
    public PositionOutOfBoundsException(String message) {
        super(message);
    }
}