package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FamilyRoomTest {
  FamilyRoom family;
  @Before
  public void setUp() throws Exception {
    family = new FamilyRoom(120.00, 4);
  }

  @Test
  public void getMaxOccupancy() {
    assertEquals(4, family.getMaxOccupancy());
  }
}