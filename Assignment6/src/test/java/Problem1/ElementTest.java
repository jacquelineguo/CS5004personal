package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ElementTest {
  Element ele;
  Element ele1;

  @Before
  public void setUp() throws Exception {
    ele = new Element(1, "A");
    ele1 = new Element(2, "B");
  }

  @Test
  public void getPriority() {
    Integer result = 1;
    assertEquals(result, ele.getPriority());
  }

  @Test
  public void getValue() {
    assertEquals("A", ele.getValue());
  }

  @Test
  public void testToString() {
    assertEquals("Element{priority=1, value='A'}", ele.toString());
    assertNotEquals("Element{priority=1, value='A'}", ele1.toString());
  }

  @Test
  public void testEquals() {
    Element newEle = new Element(1, "A");
    assertEquals(ele, ele);
    assertNotEquals(null, ele);
    assertNotEquals("P", ele);
    assertNotEquals(ele, ele1);
    assertEquals(newEle, ele);
    assertNotEquals(ele1, null);
  }

  @Test
  public void testHashCode() {
    Element newEle = new Element(1, "A");
    assertEquals(ele.hashCode(),newEle.hashCode());
    assertNotEquals(ele.hashCode(), ele1.hashCode());
  }
}