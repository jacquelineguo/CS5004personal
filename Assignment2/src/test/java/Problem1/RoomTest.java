package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RoomTest {
  Room rm;

  @Before
  public void setUp() throws Exception {
    rm = new Room(60.00, 0, 1);
  }

  @Test
  public void getMaxOccupancy() {
    assertEquals(1, rm.getMaxOccupancy());
  }

  @Test
  public void getPrice() {
    assertEquals(60.00, rm.getPrice(), 0.01);
  }

  @Test
  public void getCurrGuestNum() {
    assertEquals(0, rm.getCurrGuestNum());
  }

  @Test (expected = InvalidPriceException.class)
  public void invalidPrice() throws InvalidPriceException{
    Room rm1 = new Room(0.00, 0, 4);
    Room rm2 = new Room(-5.00, 0, 2);
  }
  @Test
  public void isAvailable() {
    assertTrue(rm.isAvailable(rm.getCurrGuestNum()));
  }

  @Test
  public void notAvailable() throws Exception{
    Room rm3 = new Room(100.00, 2, 2);
    assertFalse(rm3.isAvailable(rm3.getCurrGuestNum()));
  }

  @Test
  public void bookRoom() throws Exception{
    rm.bookRoom(1);
  }

  @Test (expected = InvalidRmNumException.class)
  public void rmOccupied() throws Exception {
    Room rm4 = new Room(120.00, 3, 4);
    rm4.bookRoom(4);
  }

  @Test (expected = InvalidRmNumException.class)
  public void invalidIncomingGuest() throws Exception {
    rm.bookRoom(3);
  }
}