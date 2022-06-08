package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoubleRoomTest {
  DoubleRoom doubleRm;
  @Before
  public void setUp() throws Exception {
    doubleRm = new DoubleRoom(100.00, 2);
  }

  @Test
  public void getOccupancy() {
    assertEquals(doubleRm.getMaxOccupancy(), 2);
  }
}