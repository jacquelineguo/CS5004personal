package Controller;

import Model.Row;
import Model.Seat;
import Model.Theater;

/**
 * DisplayTheater class can help display the seats in the theater.
 */
public class DisplayTheater {
  private static final String OCCUPIED_SEAT = "X";
  private static final String WHEELCHAIR_SEAT = "=";
  private static final String SEAT = "_";
  private static final String SPACE = " ";

  /**
   * Display the seats in the theater.
   * @param theater - the theater to display.
   */
  public static void displayTheater(Theater theater) {
    for (Row row: theater.getRowList()) {
      displayRows(row);
    }
  }

  /**
   * Helper method to help display rows in the theater.
   * @param row - rows in the theater.
   */
  private static void displayRows(Row row) {
    String symbol;
    System.out.print(row.getRowNum() + SPACE);
    if (row.getWheelchair()) {
      symbol = WHEELCHAIR_SEAT;
    } else {
      symbol = SEAT;
    }
    for (Seat seat: row) {
      displaySeats(seat, symbol);
    }
    System.out.println();
  }

  /**
   * Helper method to display seats in the row.
   * @param seat - seats in the row.
   * @param symbol - seats symbol, if it's a normal seats, the symbol is "_", if it's a wheelchair
   *               seat, the symbol is "=".
   */
  private static void displaySeats(Seat seat, String symbol) {
    if (seat.getCustomerName() != null) {
      System.out.print(SPACE + OCCUPIED_SEAT + SPACE);
    } else {
      System.out.print(SPACE + symbol + SPACE);
    }
  }
}

