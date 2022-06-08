package Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RowTest {
  Row row1;
  Row row2;
  Row row3;

  @Before
  public void setUp() throws Exception {
    row1 = new Row(1);
    row2 = new Row(2, false, 10);
    row3 = new Row(3, true, 15);
  }

  @Test (expected = IllegalArgumentException.class)
  public void negativeRowNumber() throws IllegalArgumentException {
    row2 = new Row(-1, false, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidRowNumber() throws IllegalArgumentException {
    row2 = new Row(16, false, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidSeatsNum() throws IllegalArgumentException {
    row3 = new Row(3, true, 5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void seatsNumOutOfBound() throws IllegalArgumentException {
    row3 = new Row(3, true, 28);
  }

  @Test
  public void setWheelchair() {
    row2.setWheelchair();
    assertTrue(row2.getWheelchair());
  }

  @Test
  public void getRowNum() {
    assertEquals((Integer) 1, row1.getRowNum());
  }

  @Test
  public void getWheelchair() {
    assertFalse(row2.getWheelchair());
  }

  @Test
  public void getNumOfSeats() {
    assertEquals((Integer) 10, row2.getNumOfSeats());
  }

  @Test
  public void testEquals() {
    assertEquals(row1, row1);
    assertNotEquals(row1, row2);
    assertNotEquals(null, row1);
    assertNotEquals(row2, null);
    assertNotEquals("ROW", row1);
    assertNotEquals(row2, row3);
    assertNotEquals(row3, row1);

    row3 = new Row(2, true, 10);
    assertNotEquals(row3, row2);
  }

  @Test
  public void testHashCode() {
    assertNotEquals(row1.hashCode(), row3.hashCode());
  }

  @Test
  public void testToString() {
    String result = "Row{rowNum=1, wheelchair=false, numOfSeats=10}";
    assertEquals(result, row1.toString());
  }
}