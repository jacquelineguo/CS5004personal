package Controller;

import static org.junit.Assert.*;

import Model.Row;
import Model.Theater;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ReservationsServiceTest {
  Theater theater;
  Theater theater1;
  List<Row> row1;

  Interaction interaction;

  @Before
  public void setUp() throws Exception {
    row1 = new ArrayList<>();
    Integer rows = 5;
    String theaterName = "Ragel";
    List<Integer> wheelchairRows = Arrays.asList(2, 5);
    for (int i = 0; i < rows; i++) {
      row1.add(new Row(i + 1));
    }
    List<Integer> WCRow = Arrays.asList(2, 3);
    theater = Theater.generateTheater(theaterName, row1, wheelchairRows);
    theater1 = Theater.generateTheater(theaterName, row1, WCRow);
  }

  @Test
  public void reserveSeats() {
    assertTrue(ReservationsService.reserveSeats(theater, 3,
        "Jacqueline", false));
    assertTrue(ReservationsService.reserveSeats(theater, 2,
        "Kate", true));
    assertTrue(ReservationsService.reserveSeats(theater, 5,
        "A", false));
    assertTrue(ReservationsService.reserveSeats(theater, 10,
        "Jane", false));
    assertTrue(ReservationsService.reserveSeats(theater, 10,
        "B", false));
    assertTrue(ReservationsService.reserveSeats(theater, 10,
        "C", false));
    assertFalse(ReservationsService.reserveSeats(theater, 10,
        "D", false));
    ReservationsService.reserveSeats(theater,4, "Jessica", false);
  }
}