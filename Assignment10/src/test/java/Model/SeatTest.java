package Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeatTest {
  Seat seat1;
  Seat seat2;

  @Before
  public void setUp() throws Exception {
    seat1 = new Seat("A");
    seat2 = new Seat("B", "KK");
  }

  @Test
  public void getSeatName() {
    assertEquals("A", seat1.getSeatName());
  }

  @Test
  public void getCustomerName() {
    assertEquals("KK", seat2.getCustomerName());
  }

  @Test
  public void testEquals() {
    assertEquals(seat1, seat1);
    assertNotEquals(seat1, seat2);
    assertNotEquals(null, seat1);
    assertNotEquals(seat2, null);
    assertNotEquals("seat", seat1);
  }

  @Test
  public void testHashCode() {
    assertNotEquals(seat1.hashCode(), seat2.hashCode());
  }

  @Test
  public void testToString() {
    String result = "Seat{seatName='B', customerName='KK'}";
    assertEquals(result, seat2.toString());
  }
}