package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GardeningTest {
  Gardening gardening;

  @Before
  public void setUp() throws Exception {
    gardening = new Gardening("1115", "65th Ave", PropertySize.LARGE, true,
        19);
  }

  @Test
  public void testEquals() {
    assertEquals(gardening, gardening);
    assertNotEquals(null, gardening);
    assertNotEquals("gardening", gardening);

    Gardening gardening1 = new Gardening("1111", "65th Ave",
        PropertySize.SMALL, false, 5);
    assertNotEquals(gardening, gardening1);

    Gardening gardening2 = new Gardening("1115", "65th Ave", PropertySize.LARGE,
        true, 19);
    assertEquals(gardening, gardening2);
  }

  @Test
  public void testHashCode() {
    Gardening gardening1 = new Gardening("1111", "65th Ave",
        PropertySize.SMALL, false, 5);

    Gardening gardening2 = new Gardening("1115", "65th Ave", PropertySize.LARGE,
        true, 19);
    assertNotEquals(gardening.hashCode(), gardening1.hashCode());
    assertEquals(gardening2.hashCode(), gardening.hashCode());
  }

  @Test
  public void testToString() {
    String result = "Gardening: invoice=1115 address='65th Ave' size=Large is monthly=true"
        + " serviced=19";
    assertEquals(result, gardening.toString());
  }

  @Test
  public void calculatePrice() {
    assertEquals(170.00, gardening.calculatePrice(), 0.00);

    Gardening gardening1 = new Gardening("1111", "65th Ave",
        PropertySize.SMALL, true, 5);
    assertEquals(90.00, gardening1.calculatePrice(), 0.00);
  }
}