package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SingleRoomTest {
  SingleRoom single;

  @Before
  public void setUp() throws Exception {
    single = new SingleRoom(60.00, 1);
  }

  @Test
  public void getOccupancy() {
    assertEquals(single.getMaxOccupancy(), 1);
  }
}