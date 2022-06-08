package Problem2;

import static org.junit.Assert.*;

import Problem1.EmptyPriorityQueue;
import org.junit.Before;
import org.junit.Test;

public class EmptyBagOfWordsTest {
  EmptyBagOfWords empty;
  EmptyBagOfWords empty1;

  @Before
  public void setUp() throws Exception {
    empty = new EmptyBagOfWords();
    empty1 = IBagOfWords.emptyBagOfWords();
  }

  @Test
  public void isEmpty() {
    assertTrue(empty.isEmpty());
  }

  @Test
  public void size() {
    Integer expect = 0;
    assertEquals(expect, empty.size());
  }

  @Test
  public void add() {
    BagOfWords bag = new BagOfWords("HEllo", null);
    assertEquals(bag, empty.add("Hello"));
  }

  @Test
  public void contains() {
    assertFalse(empty.contains("S"));
  }

  @Test
  public void testToString() {
    String result = "EmptyBagOfWords{}";
    assertEquals(result, empty.toString());
  }

  @Test
  public void testEquals() {
    assertEquals(empty, empty);
    assertEquals(empty, empty1);
    assertNotEquals(null, empty);
    assertNotEquals(empty, null);
    assertNotEquals("empty", empty);
  }

  @Test
  public void testHashCode() {
    assertEquals(empty.hashCode(), empty1.hashCode());

    BagOfWords bag = new BagOfWords("HEllo", null);
    assertNotEquals(bag.hashCode(), empty1.hashCode());
  }
}