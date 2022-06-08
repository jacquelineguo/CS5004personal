package Model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Row class represents the row in the theater.
 */
public class Row extends ArrayList<Seat> {
  private Integer rowNum;
  private Boolean wheelchair;
  private Integer numOfSeats;
  private static final Integer DEFAULT_SEATS_PER_ROW = 10;
  private static final Integer MAX_SEATS_PER_ROW = 26;
  private static final Integer MIN_SEATS_PER_ROW = 10;
  private static final Integer ROW_MAX = 15;
  public static final Integer ONE = 1;

  /**
   * Constructor for Row class when we only get a row number.
   * @param rowNum - row number, e.g. row number of the first row should be 1.
   * @throws IllegalArgumentException if the row number is invalid.
   */
  public Row(Integer rowNum) throws IllegalArgumentException{
    this.checkRowNum(rowNum);
    this.rowNum = rowNum;
    this.wheelchair = false;
    this.numOfSeats = DEFAULT_SEATS_PER_ROW;
    this.addSeats(this.numOfSeats);
  }

  /**
   * Constructor for Row class when we have all three fields as passed in value.
   * @param rowNum - row number, e.g. row number of the first row should be 1.
   * @param wheelchair - if the row should be set as wheelchair row.
   * @param numOfSeats - number of seat in a row.
   * @throws IllegalArgumentException if the row number and number of seats invalid.
   */
  public Row(Integer rowNum, Boolean wheelchair, Integer numOfSeats)
      throws IllegalArgumentException {
    this.checkRowNum(rowNum);
    this.wheelchair = wheelchair;
    this.checkSeatsNum(numOfSeats);
    this.numOfSeats = numOfSeats;
    this.addSeats(numOfSeats);
  }

  /**
   * Helper method which helps add seats to the row.
   * @param numOfSeats - number of seat in a row.
   */
  private void addSeats(Integer numOfSeats) {
    for (int i = 0; i < numOfSeats; i++) {
      this.add(new Seat(Character.toString((char) ('A' + i))));
    }
  }

  /**
   * Helper method which helps check if row number is valid.
   * @param rowNum - row number, e.g. row number of the first row should be 1.
   * @return true if valid.
   * @throws IllegalArgumentException if row number is invalid.
   */
  private Boolean checkRowNum(Integer rowNum) throws IllegalArgumentException{
    if (rowNum < ONE || rowNum > ROW_MAX) {
      throw new IllegalArgumentException("Row No. should be between " + ONE +
          " and " + ROW_MAX + "!");
    }
    return true;
  }

  /**
   * Helper method which helps check number of seats is valid.
   * @param numOfSeats - number of seat in a row.
   * @return true if the number of seats in each is valid.
   * @throws IllegalArgumentException if the number of seats in each is invalid.
   */
  private Boolean checkSeatsNum(Integer numOfSeats) throws IllegalArgumentException{
    if (numOfSeats < MIN_SEATS_PER_ROW || numOfSeats > MAX_SEATS_PER_ROW) {
      throw new IllegalArgumentException("Number of seats must be between " +
          MIN_SEATS_PER_ROW + " and " + MAX_SEATS_PER_ROW + "!");
    }
    return true;
  }

  /**
   * Set as wheelchair seat.
   */
  public void setWheelchair() {
    this.wheelchair = true;
  }

  /**
   * Get row number.
   * @return row number.
   */
  public Integer getRowNum() {
    return this.rowNum;
  }

  /**
   * Get if the row is wheelchair row.
   * @return true if it is, false otherwise.
   */
  public Boolean getWheelchair() {
    return this.wheelchair;
  }

  /**
   * Get number of seats in each row.
   * @return the number of seats in each row.
   */
  public Integer getNumOfSeats() {
    return this.numOfSeats;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Row seats = (Row) o;
    return Objects.equals(getRowNum(), seats.getRowNum()) && Objects
        .equals(getWheelchair(), seats.getWheelchair()) && Objects
        .equals(getNumOfSeats(), seats.getNumOfSeats());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getRowNum(), getWheelchair(), getNumOfSeats());
  }

  @Override
  public String toString() {
    return "Row{" +
        "rowNum=" + rowNum +
        ", wheelchair=" + wheelchair +
        ", numOfSeats=" + numOfSeats +
        '}';
  }
}
