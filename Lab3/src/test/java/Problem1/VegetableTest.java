package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VegetableTest {
  Vegetable carrot;

  @Before
  public void setUp() throws Exception {
    carrot = new Vegetable("Carrot", 2.0, 30,
        0316, 0327);
  }

  @Test
  public void getMeat() throws InvalidFoodQtException {
    Vegetable c = new Vegetable("Carrot", 2.0, 30,0316, 0327);
    assertTrue(c.equals(carrot));
  }
}