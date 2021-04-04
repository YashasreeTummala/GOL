import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CellTest {
    @Test
    void shouldReturnNumberOfActiveNeighborsForAGivenCell() {
        final HashSet<Cell> initialGeneration = new HashSet<>() {{
            add(new Cell(1,1));
            add(new Cell(1,2));
            add(new Cell(2,2));
        }};

        final Universe universe = new Universe(initialGeneration);
        assertThat(universe.activeNeighborsCount(new Cell(1,1)), is(equalTo(2)));
    }

    @Test
    void expectCellToDieDueToUnderPopulation() {
        Cell subjectCell = new Cell(3, 3);
        final HashSet<Cell> initialGeneration = new HashSet<>() {{
            add(new Cell(1,1));
            add(new Cell(1,2));
            add(subjectCell);
        }};
        final Universe universe = new Universe(initialGeneration);
        universe.tick();
        assertThat(universe.isActive(subjectCell), is(equalTo(false)));
    }
}
