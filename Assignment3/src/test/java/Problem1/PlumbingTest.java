package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlumbingTest {
  Plumbing plumbing;

  @Before
  public void setUp() throws Exception {
    plumbing = new Plumbing("1113", "65th Ave", PropertySize.MEDIUM,
        true, 5, 2, true);
  }

  @Test
  public void calculatePrice() {
    assertEquals(378.00, plumbing.calculatePrice(), 0.00);

    plumbing = new Plumbing("1113", "65th Ave", PropertySize.LARGE,
        true, 5, 2, true);
    assertEquals(558.00, plumbing.calculatePrice(), 0.00);

    plumbing = new Plumbing("1113", "65th Ave", PropertySize.SMALL,
        true, 5, 2, true);
    assertEquals(378.00, plumbing.calculatePrice(), 0.00);
  }

  @Test
  public void testEquals() {
    assertEquals(plumbing, plumbing);
    assertNotEquals(null, plumbing);
    assertNotEquals("plumbing", plumbing);

    Plumbing plumbing1 = new Plumbing("1111", "65th Ave",
        PropertySize.SMALL, false, 5, 1, false);
    assertNotEquals(plumbing1, plumbing);

    Plumbing plumbing2 = new Plumbing("1113", "65th Ave", PropertySize.MEDIUM,
        true, 5, 2, true);
    assertEquals(plumbing, plumbing2);

    Plumbing plumbing3 = new Plumbing("1113", "65th Ave", PropertySize.MEDIUM,
        true, 5, 5, false);
    assertNotEquals(plumbing, plumbing3);
    assertNotEquals(plumbing3, null);

  }

  @Test
  public void testHashCode() {
    Plumbing plumbing1 = new Plumbing("1111", "65th Ave",
        PropertySize.SMALL, false, 5, 1, false);
    Plumbing plumbing2 = new Plumbing("1113", "65th Ave", PropertySize.MEDIUM,
        true, 5, 2, true);

    assertEquals(plumbing.hashCode(), plumbing2.hashCode());
    assertNotEquals(plumbing1.hashCode(), plumbing.hashCode());
  }

  @Test
  public void testToString() {
    String result = "Plumbing: invoice=1113 address='65th Ave' size=Medium is monthly=true"
        + " serviced=5 licensed employee=2 is complex=true";
    assertEquals(result, plumbing.toString());
  }
}