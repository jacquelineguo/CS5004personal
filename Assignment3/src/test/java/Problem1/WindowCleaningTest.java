package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WindowCleaningTest {
  WindowCleaning windowCleaning;

  @Before
  public void setUp() throws Exception {
    windowCleaning = new WindowCleaning("1111", "65th Ave", PropertySize.SMALL,
        false, 5, 2);
  }

  @Test
  public void testGetNumOfFloor() {
    Integer result = 2;
    assertEquals(result, windowCleaning.getNumOfFloor());
  }

  @Test (expected = InvalidNumOfFloorException.class)
  public void invalidNumOfFloor() throws InvalidNumOfFloorException {
    WindowCleaning windowCleaning1 = new WindowCleaning("1111", "65th Ave",
        PropertySize.SMALL, false, 5, 5);

    WindowCleaning windowCleaning2 = new WindowCleaning("1111", "65th Ave",
        PropertySize.SMALL, false, 5, -1);
  }

  @Test
  public void testEquals() throws Exception{
    assertEquals(windowCleaning, windowCleaning);
    assertNotEquals(null, windowCleaning);
    assertNotEquals("window", windowCleaning);

    WindowCleaning windowCleaning1 = new WindowCleaning("1111", "65th Ave",
        PropertySize.SMALL, false, 5, 2);
    assertEquals(windowCleaning1, windowCleaning);

    WindowCleaning windowCleaning2 = new WindowCleaning("1111", "65th Ave",
        PropertySize.LARGE, true, 6, 2);
    assertNotEquals(windowCleaning, windowCleaning2);
    assertNotEquals(windowCleaning2, null);
  }

  @Test
  public void testHashCode() throws Exception{
    WindowCleaning windowCleaning1 = new WindowCleaning("1111", "65th Ave",
        PropertySize.SMALL, false, 5, 2);

    WindowCleaning windowCleaning2 = new WindowCleaning("1111", "65th Ave",
        PropertySize.SMALL, true, 6, 2);

    assertEquals(windowCleaning.hashCode(), windowCleaning1.hashCode());
    assertNotEquals(windowCleaning1.hashCode(), windowCleaning2.hashCode());

  }

  @Test
  public void testToString() {
    String result = "Window cleaning: invoice=1111 address='65th Ave' size=Small is monthly=false"
        + " serviced=5 number of floor=2";
    assertEquals(result, windowCleaning.toString());
  }

  @Test
  public void testCalculatePrice() throws Exception{
    assertEquals(84.0, windowCleaning.calculatePrice(), 0.0);

    WindowCleaning windowCleaning1 = new WindowCleaning("1111", "65th Ave",
        PropertySize.MEDIUM, false, 5, 1);
    assertEquals(160.0, windowCleaning1.calculatePrice(), 0.0);

    WindowCleaning windowCleaning2 = new WindowCleaning("1111", "65th Ave",
        PropertySize.SMALL, true, 5, 2);
    assertEquals(75.6, windowCleaning2.calculatePrice(), 0.0);

    WindowCleaning windowCleaning3 = new WindowCleaning("1111", "65th Ave",
        PropertySize.LARGE, false, 9, 2);
    assertEquals(168.0, windowCleaning3.calculatePrice(), 0.0);
  }

}