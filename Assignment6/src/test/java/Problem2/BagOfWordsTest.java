package Problem2;

import static org.junit.Assert.*;

import java.util.Locale;
import org.junit.Before;
import org.junit.Test;

public class BagOfWordsTest {
  BagOfWords bag;
  BagOfWords bag1;
  BagOfWords bag2;

  @Before
  public void setUp() throws Exception {
    bag = new BagOfWords("word", null);
    bag1 = bag.add("Zoo");
    bag2 = new BagOfWords("yes", bag1);
  }

  @Test
  public void isEmpty() {
    assertFalse(bag.isEmpty());
  }

  @Test
  public void size() {
    Integer expect = 1;
    assertEquals(expect, bag.size());

    Integer expect1 = 2;
    assertEquals(expect1, bag1.size());
  }

  @Test
  public void add() {
    BagOfWords expect = new BagOfWords("apple", bag);
    assertEquals(expect, bag.add("Apple"));

    BagOfWords expect1 = new BagOfWords("zoo", null);
    assertEquals(expect1.add("WORD"), bag.add("Zoo"));

    BagOfWords expect2 = new BagOfWords("hello", expect1.add("word"));
    assertEquals(expect2, bag1.add("Hello"));

    BagOfWords expect3 = new BagOfWords("word", expect1.add("yes"));
    assertEquals(expect3, expect1.add("word").add("yes"));
  }

  @Test
  public void contains() {
    assertTrue(bag.contains("word"));
    assertFalse(bag1.contains("Hi"));
    assertFalse(bag.contains("s"));
    assertTrue(bag1.contains("ZOO"));
    assertTrue(bag1.contains("word"));
  }

  @Test
  public void testToString() {
    String result = "BagOfWords{first='word', rest=BagOfWords{first='zoo', rest=null}}";
    assertEquals(result, bag1.toString());
    assertNotEquals(result, bag.toString());
  }

  @Test
  public void testEquals() {
    assertEquals(bag, bag);
    assertNotEquals(bag, bag1);
    assertNotEquals(null, bag);
    assertNotEquals(bag2, null);
    assertNotEquals("bag", bag);

    BagOfWords temp = new BagOfWords("zoo", null);
    BagOfWords expect = temp.add("yes").add("word");
    assertEquals(expect, bag2);
  }

  @Test
  public void testHashCode() {
    BagOfWords temp = new BagOfWords("zoo", null);
    BagOfWords expect = temp.add("yes").add("word");
    assertEquals(bag2.hashCode(), expect.hashCode());
    assertNotEquals(bag.hashCode(), bag2.hashCode());
  }
}