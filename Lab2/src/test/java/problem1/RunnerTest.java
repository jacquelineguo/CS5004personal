package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RunnerTest {
  private Runner r;
  private Athlete runner;
  private Name name;

  @Before
  public void setUp() throws Exception {
    name = new Name("Jack", "W", "G");
    runner = new Athlete(name, 5.00, 170.00, "NFL");
    r = new Runner(name, 5.00, 170.00, "NFL", 30.00,
  15.00, "xx");
  }

  @Test
  public void getBest5Ktime() {
    assertEquals(java.util.Optional.of(30.00), r.getBest5Ktime());
  }

  @Test
  public void getBestHalfMarathonTime() {
    assertEquals(java.util.Optional.of(15.00), r.getBestHalfMarathonTime());
  }

  @Test
  public void getFavoriteRunningEvent() {
    assertEquals("xx", r.getFavoriteRunningEvent());
  }

}