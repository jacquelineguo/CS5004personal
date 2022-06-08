package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MeatTest {
  Meat lamb;
  @Before
  public void setUp() throws Exception {
    lamb = new Meat("Lamb", 20.0, 30, 0320, 0330);
  }

  @Test
  public void getMeat() throws InvalidFoodQtException {
    Meat l = new Meat("Lamb", 20.0, 30, 0320, 0330);
    assertTrue(lamb.equals(l));
  }
}