package Model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Theater class represents the movie theater that has row list, theater name, and wheelchair rows
 * as it's fields.
 */
public class Theater {
  private String theaterName;
  private List<Row> rowList;
  private List<Integer> wheelChairRows;
  private static final Integer MINI_ROWS = 5;
  private static final Integer MAX_ROWS = 20;
  public static final Integer ZERO = 0;
  private static Theater instance;

  /**
   * Constructor for Theater class.
   * @param theaterName - theater name.
   * @param rowList - row list which represents the rows in the theater.
   * @param wheelChairRows - wheelchair row number as a list.
   * @throws IllegalArgumentException if the rows is not valid.
   */
  private Theater(String theaterName, List<Row> rowList, List<Integer> wheelChairRows) throws
      IllegalArgumentException {
    this.theaterName = theaterName;
    this.checkRows(rowList);
    this.rowList = rowList;
    this.wheelChairRows = this.checkWheelChairRows(wheelChairRows);
    this.setWheelChairRow();
  }

  /**
   * Generate a theater with the given fields.
   * @param theaterName - theater name.
   * @param rowList - row list which represents the rows in the theater.
   * @param wheelChairRows - wheelchair row number as a list.
   * @return a Theater class.
   * @throws IllegalArgumentException if the rows is not valid.
   */
  public static Theater generateTheater(String theaterName, List<Row> rowList,
      List<Integer> wheelChairRows) throws IllegalArgumentException{
    if (instance == null)
      return new Theater(theaterName, rowList, wheelChairRows);
    return instance;
  }

  /**
   * Helper method which helps set the wheelchair rows.
   */
  private void setWheelChairRow() {
    for (Integer row: this.wheelChairRows) {
      this.rowList.get(row - Row.ONE).setWheelchair();
    }
  }

  /**
   * Helper method which helps check if the row list is valid.
   * @param rowList - row list which represents the rows in the theater.
   * @return true if it's valid, false otherwise.
   * @throws IllegalArgumentException if the row list is not valid.
   */
  private Boolean checkRows(List<Row> rowList) throws IllegalArgumentException{
    if (rowList.size() < MINI_ROWS || rowList.size() > MAX_ROWS) {
      throw new IllegalArgumentException("The correct number of rows in the theater should be "
          + "between " + MINI_ROWS + " and " + MAX_ROWS + "!");
    }
    return true;
  }

  /**
   * Helper method which helps check if the wheelchair rows is valid.
   * @param wheelChairRows - wheelchair row number as a list.
   * @return true if the wheelchair rows is valid, false otherwise.
   * @throws IllegalArgumentException it the the wheelchair rows is invalid.
   */
  private List<Integer> checkWheelChairRows(List<Integer> wheelChairRows) throws
      IllegalArgumentException{
    if (wheelChairRows.size() < Row.ONE) {
      throw new IllegalArgumentException("The rows for wheelchair should be at least " +
          Row.ONE + "!");
    }
    List<Integer> outOfBoundRows = wheelChairRows.stream().
        filter(row -> row < Row.ONE || row > this.rowList.size()).
        collect(Collectors.toList());
    if (outOfBoundRows.size() != ZERO) {
      throw new IllegalArgumentException("Wheelchair rows should be in the bound! (Minimum: " +
          Row.ONE + ", Maximum: " + this.rowList.size() + ").");
    }
    return wheelChairRows;
  }

  /**
   * Get the Theater name.
   * @return the Theater name.
   */
  public String getTheaterName() {
    return theaterName;
  }

  /**
   * Get the list of the rows.
   * @return the list of the rows.
   */
  public List<Row> getRowList() {
    return rowList;
  }

  /**
   * Get the list of row numbers of the wheelchair row.
   * @return the list of row numbers of the wheelchair row.
   */
  public List<Integer> getWheelChairRows() {
    return wheelChairRows;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    Theater theater = (Theater) o;
    return Objects.equals(getTheaterName(), theater.getTheaterName()) && Objects
        .equals(getRowList(), theater.getRowList()) && Objects
        .equals(getWheelChairRows(), theater.getWheelChairRows());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTheaterName(), getRowList(), getWheelChairRows());
  }

  @Override
  public String toString() {
    return "Theater{" +
        "theaterName='" + theaterName + '\'' +
        ", rowList=" + rowList +
        ", wheelChairRows=" + wheelChairRows +
        '}';
  }
}
