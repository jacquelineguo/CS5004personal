package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class AthleteTest {
  private Athlete mrW;
  private Name name;


  @Before
  public void setUp() throws Exception {
    name = new Name("Jack", "W", "G");
    mrW = new Athlete(name, 5.00, 170.00, "NFL");
  }

  @Test
  public void getAthletesName() {
    assertEquals("Jack", name.getFirstName());
    assertEquals("W", name.getMiddleName());
    assertEquals("G", name.getLastName());
  }

  @Test
  public void getHeight() {
    assertEquals(java.util.Optional.of(5.00), mrW.getHeight());
  }

  @Test
  public void getWeight() {
    assertEquals(java.util.Optional.of(170.00), mrW.getWeight());
  }

  @Test
  public void getLeague() {
    assertEquals("NFL", mrW.getLeague());
  }

}