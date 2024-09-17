import java.util.Set;

public class ConsoleDisplay implements Display {

    @Override
    public void notifyNewSimulation(int iterations, int rows, int columns) {
        System.out.println("Début de la simulation.");
        System.out.println("Nombre d'itérations prévues : " + iterations);
        System.out.println("Taille de la grille : " + rows + "x" + columns);
    }

    @Override
    public void notifyNewGeneration(int generation, Set<Position> aliveCells) {
        System.out.println("Génération N° : " + generation);
        System.out.println("Cellules vivantes : " + aliveCells.size());
        System.out.println("Positions des cellules vivantes : " + aliveCells);
    }
}
