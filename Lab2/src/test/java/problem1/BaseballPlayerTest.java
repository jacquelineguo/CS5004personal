package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BaseballPlayerTest {
  private BaseballPlayer b;
  private Name name;

  @Before
  public void setUp() throws Exception {
    name = new Name("Jack", "W", "G");
    b = new BaseballPlayer(name, 6.0, 180.0, "NAL",
        "WOW", 5.0, 2);
  }

  @Test
  public void getTeam() {
    assertEquals("WOW", b.getTeam());
  }

  @Test
  public void getAverageBatting() {
    assertEquals(java.util.Optional.of(5.0), b.getAverageBatting());
  }

  @Test
  public void getSeasonHomeRuns() {
    assertEquals(java.util.Optional.of(2), b.getSeasonHomeRuns());
  }

}