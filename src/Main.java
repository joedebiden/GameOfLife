public class Main {

    public static void main(String[] args) {
        //Position pos1 = new Position(2,3);
        //Position pos2 = new Position(2, 3);

        //System.out.println("Position 1: " + pos1);
        //System.out.println("Position 2: " + pos2);

        // Test de l'égalité physique (référence)
        //boolean equalityPhysical = (pos1 == pos2);
        //System.out.println("Egalité physique : " + equalityPhysical);

        // Test de l'équivalence d'état (contenu)
        //boolean equalityState = pos1.equals(pos2);
        //System.out.println("Equivalence d'état: " + equalityState);

        //création d'une position de départ
        Position pos = new Position(2, 3);
        Position NeighborNE = pos.getNeighbor(Direction.NE);

        System.out.println("Position de départ : " + pos);
        System.out.println("Position voisine au Nord-Est : " + NeighborNE);

    }

}
