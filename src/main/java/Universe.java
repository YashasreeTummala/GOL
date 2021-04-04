import java.util.HashSet;
import java.util.Set;

public class Universe {
    private final Set<Cell> currentGeneration;

    public Universe(HashSet<Cell> initialGeneration) {
        currentGeneration = initialGeneration;
    }

    public int activeNeighborsCount(Cell cell) {
        int neighborsCount = 0;
        for (Cell currentCell : currentGeneration) {
            if (currentCell.isNeighborOf(cell)) {
                neighborsCount++;
            }
        }
        return neighborsCount;
    }

    public void tick() {
        // TODO: Process the universe again
    }

    public String isActive(Cell cell) {
        // TODO: Check if this cell is active
        return null;
    }
}
