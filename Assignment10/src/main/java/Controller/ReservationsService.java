package Controller;

import Model.Row;
import Model.Seat;
import Model.Theater;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ReservationsService class represents the action that customer reserve the seats in the theater.
 */
public class ReservationsService {
  private static final Integer OFF_SET = 2;

  /**
   * Constructor for ReservationsService class.
   * @param theater - the theater customer go to watch movie.
   * @param reserveNum - the number of seats the customer want to reserve.
   * @param customerName - customer name.
   * @param wheelchair - if the customer want the wheelchair seats.
   * @return true if the seats reserved, false otherwise.
   */
  public static Boolean reserveSeats(Theater theater, Integer reserveNum,
      String customerName, Boolean wheelchair) {
    if (reserveNum > theater.getRowList().get(Theater.ZERO).getNumOfSeats()) {
      return false;
    }
    if (wheelchair) {
      Map<Integer, List<String>> bestSeats = findBestWheelchairSeat(theater, reserveNum);
      if (bestSeats.isEmpty())
        return false;
      setAsReserved(bestSeats, theater, reserveNum, customerName);
      return true;
    } else {
      Map<Integer, List<String>> bestSeats = findBestSeats(theater, reserveNum);
      if (bestSeats.isEmpty()) {
        bestSeats = findBestWheelchairSeat(theater, reserveNum);
      }
      if (bestSeats.isEmpty()) {
        return false;
      }
      setAsReserved(bestSeats, theater, reserveNum, customerName);
      return true;
    }
  }

  /**
   * Help method which helps find the best normal seats for the customer, the best seats should be
   * in the middle of the theater.
   * @param theater - the theater customer go to watch movie.
   * @param reserveNum - the number of seats the customer want to reserve.
   * @return a HashMap contain the row number as the key, and the list of seats as the value.
   */
  private static Map<Integer, List<String>> findBestSeats(Theater theater, Integer reserveNum) {
    Map<Integer, List<String>> bestSeats = new HashMap<>();
    Integer startRow = theater.getRowList().size() / OFF_SET;
    Boolean reserved = false;
    Integer lineOffset = 0;
    while (!reserved && startRow >= Theater.ZERO
        && startRow <= theater.getRowList().size() - Row.ONE) {
      if (theater.getRowList().get(startRow).getWheelchair()) {
        lineOffset++;
        startRow = switchRow(lineOffset, startRow);
        continue;
      }
      List<Seat> availableSeats = theater.getRowList().get(startRow).stream().
          filter(seat -> seat.getCustomerName() == null).collect(Collectors.toList());
      if (availableSeats.size() >= reserveNum) {
        reserved = true;
        bestSeats.put(startRow, availableSeats.stream().
            map(Seat::getSeatName).collect(Collectors.toList()));
        return bestSeats;
      }
      lineOffset++;
      startRow = switchRow(lineOffset, startRow);
    }
    return bestSeats;
  }

  /**
   * Help method which helps find the best wheelchair seats for the customer, the best seats should
   * be in the middle of the theater.
   * @param theater - the theater customer go to watch movie.
   * @param reserveNum - the number of seats the customer want to reserve.
   * @return a HashMap contain the row number as the key, and the list of seats as the value.
   */
  private static Map<Integer, List<String>> findBestWheelchairSeat(Theater theater,
      Integer reserveNum) {
    Map<Integer, List<String>> bestSeats = new HashMap<>();
    Integer startRow = theater.getRowList().size() / OFF_SET;
    Boolean reserved = false;
    Integer lineOffset = 0;
    while (!reserved && startRow >= Theater.ZERO && startRow
        <= theater.getRowList().size() - Row.ONE) {
      if (theater.getRowList().get(startRow).getWheelchair()) {
        List<Seat> availableSeats = theater.getRowList().get(startRow).stream()
            .filter(seat -> seat.getCustomerName() == null)
            .collect(Collectors.toList());
        if (availableSeats.size() >= reserveNum) {
          reserved = true;
          bestSeats.put(startRow, availableSeats.stream().map(Seat::getSeatName)
              .collect(Collectors.toList()));
          return bestSeats;
        }
      }
      lineOffset++;
      startRow = switchRow(lineOffset, startRow);
    }
    return bestSeats;
  }

  /**
   * Helper method which helps set the seats as reserved.
   * @param bestSeats - the best found seats for customer.
   * @param theater - the theater customer go to watch movie.
   * @param reserveNum - the number of seats the customer want to reserve.
   * @param customerName - customer name.
   */
  private static void setAsReserved(Map<Integer, List<String>> bestSeats, Theater theater,
      Integer reserveNum, String customerName) {
    for (Integer rowNo: bestSeats.keySet()) {
      Row newRow = theater.getRowList().get(rowNo);
      for (int i = 0; i < newRow.size(); i++) {
        if (newRow.get(i).getSeatName().equals(bestSeats.get(rowNo).get(Theater.ZERO))) {
          for (int j = 0; j < reserveNum; j++) {
            newRow.set(i + j, new Seat(bestSeats.get(rowNo).get(j), customerName));
          }
          break;
        }
      }
    }
  }

  private static Integer switchRow(Integer lineOffset, Integer startRow) {
    if (lineOffset % OFF_SET == Theater.ZERO) {
      startRow += lineOffset;
    } else {
      startRow -= lineOffset;
    }
    return startRow;
  }
}
