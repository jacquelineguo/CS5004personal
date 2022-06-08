package View;

import Controller.Interaction;
import Model.Row;
import Model.Theater;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ReservationSystem class represents the system to reserve movie tickets.
 */
public class ReservationSystem {

  public static void main(String[] args) {
    final Integer OFFSET = 1;
    List<Row> listOfRows = new ArrayList<>();
    Integer numOfRows = 10;
    String theaterName = "Regal";
    for (int i = 0; i < numOfRows; i++) {
      listOfRows.add(new Row(i + OFFSET));
    }

    List<Integer> wRows = Arrays.asList(2, 10);
    Theater theater = Theater.generateTheater(theaterName, listOfRows, wRows);

    Interaction interact = new Interaction(theater);
    interact.makeAction();
  }
}
