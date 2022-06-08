package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {
  PriorityQueue pq;
  PriorityQueue pq1;
  EmptyPriorityQueue empty;
  Element ele;
  Element ele1;

  @Before
  public void setUp() throws Exception {
    ele = new Element(1, "A");
    ele1 = new Element(5, "CD");
    pq = new PriorityQueue(ele, null);
    pq1 = new PriorityQueue(ele1, pq);
    empty = IPriorityQueue.creatEmpty();
  }

  @Test
  public void isEmpty() {
    assertTrue(empty.isEmpty());
    assertFalse(pq.isEmpty());
  }

  @Test
  public void add() {
    PriorityQueue newPQ = pq.add(5, "CD");
    assertEquals(pq1,newPQ);

    PriorityQueue testPQ = new PriorityQueue(ele1, pq.add(3, "C"));
    assertEquals(testPQ, pq1.add(3, "C"));
  }

  @Test
  public void peek() {
    PriorityQueue test = pq1.add(5, "W");
    assertEquals("W | CD", test.peek());

    assertEquals("A", pq.peek());
    assertEquals("CD", pq1.peek());
  }

  @Test
  public void pop() {
    assertEquals(null, pq.pop());
    assertEquals(pq, pq1.pop());

    PriorityQueue test = pq1.add(5, "W");
    assertEquals(pq, test.pop());
  }

  @Test
  public void testToString() {
    String result = "PriorityQueue{first=Element{priority=5, value='CD'}, "
        + "rest=PriorityQueue{first=Element{priority=1, value='A'}, rest=null}}";
    assertEquals(result, pq1.toString());
    assertNotEquals(result, pq.toString());
  }

  @Test
  public void testEquals() {
    assertEquals(pq, pq);
    assertNotEquals(pq, pq1);
    assertNotEquals(null, pq);
    assertNotEquals(pq1, null);
    assertNotEquals("pq", pq);

    EmptyPriorityQueue expect = new EmptyPriorityQueue();
    assertNotEquals(expect, pq);
  }

  @Test
  public void testHashCode() {
    PriorityQueue test = pq1.pop();
    assertEquals(pq.hashCode(), test.hashCode());
    assertNotEquals(pq.hashCode(), pq1.hashCode());
  }
}