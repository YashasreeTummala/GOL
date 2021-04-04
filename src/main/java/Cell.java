import static java.lang.Math.abs;

import java.util.Objects;

public class Cell {
  private final Integer xCoordinate;
  private final Integer yCoordinate;

  public Cell(int xCoordinate, int yCoordinate) {
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
  }

  public boolean isNeighborOf(Cell otherCell) {
    if (this.equals(otherCell)) {
      return false;
    }

    if (abs(this.xCoordinate - otherCell.xCoordinate) > 1) {
      return false;
    }

    if (abs(this.yCoordinate - otherCell.yCoordinate) > 1) {
      return false;
    }

    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Cell cell = (Cell) o;

    if (!Objects.equals(xCoordinate, cell.xCoordinate)) return false;
    return Objects.equals(yCoordinate, cell.yCoordinate);
  }

  @Override
  public int hashCode() {
    int result = xCoordinate.hashCode();
    result = 31 * result + yCoordinate.hashCode();
    return result;
  }
}
