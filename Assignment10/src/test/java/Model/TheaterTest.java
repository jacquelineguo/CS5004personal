package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TheaterTest {
  Theater theater1;
  Theater theater2;
  List<Row> row1;
  List<Row> row2;
  List<Integer> wheelchairRows;
  Row row;

  @Before
  public void setUp() throws Exception {
    row = new Row(1);
    row1 = new ArrayList<>();
    Integer rows = 5;
    String theaterName = "Ragel";
    wheelchairRows = Arrays.asList(2, 5);
    for (int i = 0; i < rows; i++) {
      row1.add(new Row(i + 1));
    }
    theater1 = Theater.generateTheater(theaterName, row1, wheelchairRows);
    row2 = new ArrayList<>();
    for (int j = 0; j < 6; j++) {
      row2.add(new Row(j + 1));
    }

  }

  @Test
  public void generateTheater() {
    theater2 = Theater.generateTheater("AMC", row2, wheelchairRows);
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidRows() throws IllegalArgumentException{
    row1 = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      row1.add(new Row(i + 1));
    }
    theater2 = Theater.generateTheater("AMC", row1, wheelchairRows);
  }

  @Test (expected = IllegalArgumentException.class)
  public void rowOutOfBound() {
    row1 = new ArrayList<>();
    for (int i = 0; i < 21; i++) {
      row1.add(new Row(i + 1));
    }
    theater2 = Theater.generateTheater("AMC", row1, wheelchairRows);
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidWCRow() throws IllegalArgumentException {
    wheelchairRows = new ArrayList<>();
    theater2 = Theater.generateTheater("AMC", row2, wheelchairRows);
  }

  @Test(expected = IllegalArgumentException.class)
  public void outOfBoundWCRow() throws IllegalArgumentException {
    wheelchairRows = Arrays.asList(1, 2, 3, 4, 5, 6);
    theater2 = Theater.generateTheater("AMC", row1, wheelchairRows);
  }

  @Test
  public void getTheaterName() {
    assertEquals("Ragel", theater1.getTheaterName());
  }

  @Test
  public void getRowList() {
    assertEquals(row1, theater1.getRowList());
  }

  @Test
  public void getWheelChairRows() {
    assertEquals(wheelchairRows, theater1.getWheelChairRows());
  }

  @Test
  public void testEquals() {
    theater2 = Theater.generateTheater("AMC", row2, wheelchairRows);
    assertEquals(theater1, theater1);
    assertNotEquals(theater1, theater2);
    assertNotEquals(null, theater1);
    assertNotEquals(theater2, null);
    assertNotEquals("theater", theater1);

    theater2 = Theater.generateTheater("Ragel", row2, wheelchairRows);
    assertNotEquals(theater1, theater2);
    assertNotEquals(theater2, row);
  }

  @Test
  public void testHashCode() {
    theater2 = Theater.generateTheater("Ragel", row2, wheelchairRows);
    assertNotEquals(theater1.hashCode(), theater2.hashCode());
  }

  @Test
  public void testToString() {
    String result = "Theater{theaterName='Ragel', rowList=[Row{rowNum=1, wheelchair=false, "
        + "numOfSeats=10}, Row{rowNum=2, wheelchair=true, numOfSeats=10}, Row{rowNum=3, "
        + "wheelchair=false, numOfSeats=10}, Row{rowNum=4, wheelchair=false, numOfSeats=10}, "
        + "Row{rowNum=5, wheelchair=true, numOfSeats=10}], wheelChairRows=[2, 5]}";
    assertEquals(result, theater1.toString());
  }
}