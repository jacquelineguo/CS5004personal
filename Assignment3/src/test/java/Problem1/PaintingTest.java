package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaintingTest {
  Painting painting;

  @Before
  public void setUp() throws Exception {
    painting = new Painting("1234", "65th Ave", PropertySize.MEDIUM, true,
        40, 3);
  }

  @Test
  public void testToString() {
    String result = "Painting: invoice=1234 address='65th Ave' size=Medium is monthly=true"
        + " serviced=40 pets=3";
    assertEquals(result, painting.toString());
  }

  @Test
  public void testEquals() {
    assertEquals(painting, painting);
    assertNotEquals(null, painting);
    assertNotEquals("painting", painting);

    Painting painting1 = new Painting("1234", "65th Ave", PropertySize.MEDIUM,
        true, 40, 3);
    assertEquals(painting1, painting);

    Painting painting2 = new Painting("1234", "65th Ave", PropertySize.MEDIUM,
        false, 40, 3);
    assertNotEquals(painting, painting2);
  }

  @Test
  public void testHashCode() {
    Painting painting1 = new Painting("1234", "65th Ave", PropertySize.MEDIUM,
        true, 40, 3);
    Painting painting2 = new Painting("1234", "65th Ave", PropertySize.MEDIUM,
        false, 40, 3);
    assertEquals(painting.hashCode(), painting1.hashCode());
    assertNotEquals(painting1.hashCode(), painting2.hashCode());
  }

  @Test
  public void calculatePrice() {
    assertEquals(1232.64, painting.calculatePrice(), 0.00);

    Painting painting1 = new Painting("1234", "65th Ave", PropertySize.LARGE,
        true, 49, 0);
    assertEquals(960.00, painting1.calculatePrice(), 0.00);

    Painting painting2 = new Painting("1234", "65th Ave", PropertySize.SMALL,
        true, 4, 2);
    assertEquals(1209.60, painting2.calculatePrice(), 0.00);
  }

  @Test (expected = IllegalStateException.class)
  public void invalidPropertySize() throws IllegalStateException {
    Painting painting1 = new Painting("1234", "65th Ave", PropertySize.EMPTY,
        true, 49, 0);
    assertEquals(960.00, painting1.calculatePrice(), 0.00);
  }
}