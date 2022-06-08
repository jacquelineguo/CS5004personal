package Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
  Item package1;
  Recipient msT;

  @Before
  public void setUp() throws Exception {
    msT = new Recipient("Alice", "Jackson", "ajackson@gmail.com");
    package1 = new Item(4, 5, 6, msT);
  }

  @Test
  public void getWidth() {
    assertEquals(4, package1.getWidth());
  }

  @Test
  public void getHeight() {
    assertEquals(5, package1.getHeight());
  }

  @Test
  public void getDepth() {
    assertEquals(6, package1.getDepth());
  }

  @Test
  public void getRecipient() {
    assertTrue(msT.equals(package1.getRecipient()));
  }

  @Test (expected = InvalidSizeDimensionException.class)
  public void invalidWidth() throws InvalidSizeDimensionException{
    Item package2 = new Item(0,4, 5, msT);
    Item package3 = new Item(-5, 4, 5, msT);
  }

  @Test (expected = InvalidSizeDimensionException.class)
  public void invalidHeight() throws InvalidSizeDimensionException{
    Item package2 = new Item(5,0, 5, msT);
    Item package3 = new Item(9, -5, 5, msT);
  }

  @Test (expected = InvalidSizeDimensionException.class)
  public void invalidDepth() throws InvalidSizeDimensionException{
    Item package2 = new Item(5,4, 0, msT);
    Item package3 = new Item(6, 4, -5, msT);
  }
}