package Controller;

import static org.junit.Assert.*;

import Model.Row;
import Model.Theater;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class DisplayTheaterTest {
  Theater theater;
  List<Row> row1;

  @Before
  public void setUp() throws Exception {
    row1 = new ArrayList<>();
    Integer rows = 5;
    String theaterName = "Ragel";
    List<Integer> wheelchairRows = Arrays.asList(2, 5);
    for (int i = 0; i < rows; i++) {
      row1.add(new Row(i + 1));
    }
    theater = Theater.generateTheater(theaterName, row1, wheelchairRows);
  }

  @Test
  public void displayTheater() {
    DisplayTheater.displayTheater(theater);
  }
}