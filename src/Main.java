import java.util.HashSet;
import java.util.Set;

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
        //Position pos = new Position(2, 3);
        //Position NeighborNE = pos.getNeighbor(Direction.NE);

        //System.out.println("Position de départ : " + pos);
        //System.out.println("Position voisine au Nord-Est : " + NeighborNE);

        //création d'un ensemble de positions pour les cellules alives
        //Set<Position> aliveCells = new HashSet<>();
        //aliveCells.add(new Position(1, 2));
        //aliveCells.add(new Position(2, 2));
        //aliveCells.add(new Position(3, 3));

        //System.out.println("Cellule vivante : *\nCellule morte : . ");


        //création de la grille
        //Grid grid = new Grid(5,5, aliveCells);
        //System.out.println(grid);

        //System.out.println("Cellule vivante : " + grid.getAliveCellCount());

        //changer l'état d'une cellule à la main
        //grid.setCellStateAt(new Position(2, 2), false);
        //System.out.println(grid);

        //test état cellule hors des limites
        //System.out.println("Etat cellule hors limite : " + grid.getCellStateAt(new Position(10, 10)));

        // Initialisation de la configuration initiale
        //Set<Position> aliveCells = new HashSet<>();
        //aliveCells.add(new Position(1, 1));
        //aliveCells.add(new Position(1, 2));
        //aliveCells.add(new Position(2, 1));
        //aliveCells.add(new Position(2, 2));

        // Création de la grille 5x5 avec des cellules vivantes initiales
        //Grid grid = new Grid(5, 5, aliveCells);

        // Création de la simulation du jeu de la vie pour 10 itérations
        //GameOfLife gameOfLife = new GameOfLife(grid, 10);

        // Exécution de la simulation
        //System.out.println("Simulation commence...");
        //gameOfLife.execute();
        //System.out.println("Simulation terminée.");
        try {
            // Initialisation de la configuration initiale des cellules vivantes
            Set<Position> aliveCells = new HashSet<>();
            aliveCells.add(new Position(61, 51));
            aliveCells.add(new Position(16, 52));
            aliveCells.add(new Position(26, 14));
            aliveCells.add(new Position(24, 52));
            aliveCells.add(new Position(61, 56));
            aliveCells.add(new Position(16, 2));
            aliveCells.add(new Position(52, 15));
            aliveCells.add(new Position(42, 25));


            // Création de la grille 5x5 avec des cellules vivantes
            Grid grid = new Grid(100, 100, aliveCells);

            // Affichage de la grille
            System.out.println(grid);



        } catch (InvalidGridSizeException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (PositionOutOfBoundsException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

    }




}
