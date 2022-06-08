package Problem2;

import static org.junit.Assert.*;

import Problem1.CourseCatalogs;
import org.junit.Before;
import org.junit.Test;

public class SetTest {
  Set set1;
  Set set2;
  Set set4;

  @Before
  public void setUp() throws Exception {
    set1 = new Set();
    set4 = set1.add(1);
    set4 = set4.add(2);
    set2 = new Set();
  }

  @Test
  public void emptySet() {
    Set set3 = set1.emptySet();
    assertTrue(set3.isEmpty());
  }

  @Test
  public void isEmpty() {
    assertTrue(set2.isEmpty());
    assertFalse(set4.isEmpty());
  }

  @Test
  public void add() {
    set2 = set2.add(1);
    set2 = set2.add(2);
    set2 = set2.add(2);
    assertTrue(set4.equals(set2));

    set2 = set2.add(3);
    assertFalse(set4.equals(set2));
  }

  @Test
  public void contains() {
    assertTrue(set4.contains(2));
    assertFalse(set4.contains(5));
  }

  @Test
  public void remove() {
    Integer[] arr = new Integer[]{1, 2, 3};
    Set sett = new Set(arr);
    sett = sett.remove(3);
    assertTrue(set4.equals(sett));
    sett = sett.remove(2);
    sett = sett.remove(1);
    assertTrue(sett.isEmpty());
    Set set5 = set4.remove(3);
    assertTrue(set5.equals(set4));

    set4 = set4.add(6);
    set4 = set4.add(10);
    set4 = set4.remove(6);
//    Integer[] arr1 = new Integer[]{1, 2, 10};
//    Set set = new Set(arr1);
//    assertTrue(set4.equals(set));
  }

  @Test
  public void size() {
    Integer result = 2;
    assertEquals(result, set4.size());
  }

  @Test
  public void testEquals() {
    Integer[] arr = new Integer[]{2, 1};
    Set set = new Set(arr);
    assertEquals(set4, set4);
    assertNotEquals(null, set4);
    assertTrue(set2.equals(set2));
    assertFalse(set2.equals(set4));
    assertFalse(set2.equals(null));
    assertFalse(set2.equals(""));

    assertTrue(set4.equals(set));
  }

  @Test
  public void testHashCode() {
    Set set = new Set();
    assertTrue(set2.hashCode() == set.hashCode());
    assertFalse(set4.hashCode() == set.hashCode());
  }

  @Test
  public void testToString() {
    String result = "Set{set=[1, 2], size=2}";
    assertEquals(result, set4.toString());
  }
}