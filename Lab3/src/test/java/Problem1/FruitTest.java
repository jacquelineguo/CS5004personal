package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FruitTest {
  Fruit apple;

  @Before
  public void setUp() throws Exception {
    apple = new Fruit("Apple", 3.0, 50, 0316, 0331);
  }

  @Test
  public void getMeat() throws InvalidFoodQtException {
    Fruit a = new Fruit("Apple", 3.0, 50, 0316, 0331);
    assertTrue(a.equals(apple));
  }
}