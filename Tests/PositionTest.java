public class PositionTest {


    public static void main(String[] args) {
        Position pos1 = new Position(2,3);
        Position pos2 = new Position(2, 4);

        System.out.println("Position 1: " + pos1);
        System.out.println("Position 2: " + pos2);

        boolean equalityPhysical = (pos1 == pos2);
        System.out.println("Egalité physique : " + equalityPhysical);

        boolean equalityState = pos1.equals(pos2);
        System.out.println("Equivalence d'état: " + equalityState);
    }
}
