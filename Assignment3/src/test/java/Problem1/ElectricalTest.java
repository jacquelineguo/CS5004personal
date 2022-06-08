package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ElectricalTest {
  Electrical electrical;

  @Before
  public void setUp() throws Exception {
    electrical = new Electrical("1113", "65th Ave", PropertySize.MEDIUM,
        true, 5, 1, true);
  }

  @Test (expected = InvalidLicensedEmployeeException.class)
  public void exceedMaxEmployee() throws InvalidLicensedEmployeeException{
    electrical = new Electrical("1113", "65th Ave", PropertySize.MEDIUM,
        true, 5, 5, true);
  }

  @Test
  public void testGetLicensedEmployee() throws Exception{
    Integer result = 2;
    assertEquals(result, electrical.getLicensedEmployee());

    Electrical electrical1 = new Electrical("1113", "65th Ave",
        PropertySize.MEDIUM, true, 5, 0, false);
    Integer result1 = 1;
    assertEquals(result1, electrical1.getLicensedEmployee());

    Electrical electrical2 = new Electrical("1113", "65th Ave",
        PropertySize.LARGE, true, 5, 3, true);
    Integer result2 = 3;
    assertEquals(result2, electrical2.getLicensedEmployee());
  }

  @Test
  public void calculatePrice() {
    assertEquals(405.00, electrical.calculatePrice(), 0.00);
  }

  @Test
  public void testEquals() throws Exception{
    assertEquals(electrical, electrical);
    assertNotEquals(null, electrical);
    assertNotEquals("electrical", electrical);

    Electrical electrical1 = new Electrical("1111", "65th Ave",
        PropertySize.SMALL, false, 5, 1, false);
    assertNotEquals(electrical, electrical1);

    Electrical electrical2 = new Electrical("1113", "65th Ave", PropertySize.MEDIUM,
        true, 5, 1, true);
    assertEquals(electrical, electrical2);
  }

  @Test
  public void testHashCode() throws Exception{
    Electrical electrical1 = new Electrical("1111", "65th Ave",
        PropertySize.SMALL, false, 5, 1, false);

    Electrical electrical2 = new Electrical("1113", "65th Ave", PropertySize.MEDIUM,
        true, 5, 1, true);
    assertEquals(electrical.hashCode(), electrical2.hashCode());
    assertNotEquals(electrical.hashCode(), electrical1.hashCode());
  }

  @Test
  public void testToString() {
    String result = "Electrical: invoice=1113 address='65th Ave' size=Medium is monthly=true"
        + " serviced=5 licensed employee=2 is complex=true";
    assertEquals(result, electrical.toString());
  }
}