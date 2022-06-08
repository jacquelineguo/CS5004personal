package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FoodOrderingSystemTest {
  FoodOrderingSystem order;


  @Before
  public void setUp() throws Exception {
    order = new FoodOrderingSystem("Ms. J");
  }

  @Test
  public void getRetailer() {
    assertEquals("Ms. J", order.getRetailer());
  }

  @Test
  public void addMeat() throws InvalidFoodQtException{
    Meat lamb = new Meat("lamb", 20.0, 30,
        0320, 0330);
    Meat added = order.addMeat("lamb", 20.0, 30,
        0320, 0330);
    assertTrue(lamb.equals(added));
  }

  @Test
  public void addFruit() throws InvalidFoodQtException{
    Fruit apple = new Fruit("Apple", 3.0, 50,
        0316, 0331);
    Fruit added = order.addFruit("Apple", 3.0, 50,
        0316, 0331);
    assertTrue(apple.equals(added));
  }

  @Test
  public void addVegetable() throws InvalidFoodQtException{
    Vegetable carrot = new Vegetable("Carrot", 2.0, 30,
        0316, 0327);
    Vegetable added = order.addVegetable("Carrot", 2.0, 30,
        0316, 0327);
    assertTrue(carrot.equals(added));
  }

  @Test
  public void addRice() throws InvalidFoodQtException{
    Rice blackRice = new Rice("Black Rice", 40, 70);
    Rice added = order.addRice("Black Rice", 40, 70);
    assertTrue(blackRice.equals(added));
  }

  @Test
  public void addPasta() throws InvalidFoodQtException{
    Pasta pasta = new Pasta("Italian Pasta", 16.0, 36);
    Pasta added = order.addPasta("Italian Pasta", 16.0, 36);
    assertTrue(pasta.equals(added));
  }
}