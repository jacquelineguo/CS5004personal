package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptyPriorityQueueTest {
  EmptyPriorityQueue emptyPQ;


  @Before
  public void setUp() throws Exception {
    emptyPQ = new EmptyPriorityQueue();
    EmptyPriorityQueue empty = IPriorityQueue.creatEmpty();
  }

  @Test
  public void isEmpty() {
    assertEquals(true, emptyPQ.isEmpty());
  }

  @Test
  public void add() {
    Element ele = new Element(1, "A");
    PriorityQueue newPQ = new PriorityQueue(ele, null);
    assertEquals(newPQ, emptyPQ.add(1, "A"));
  }

  @Test (expected = PeekOnEmptyPQException.class)
  public void peek() throws PeekOnEmptyPQException{
    emptyPQ.peek();
  }

  @Test (expected = PopOnEmptyPQException.class)
  public void pop() throws PopOnEmptyPQException{
    emptyPQ.pop();
  }

  @Test
  public void testToString() {
    assertEquals("EmptyPriorityQueue", emptyPQ.toString());
  }

  @Test
  public void testHashCode() {
    Element ele = new Element(1, "A");
    PriorityQueue newPQ = new PriorityQueue(ele, null);
    EmptyPriorityQueue empty = new EmptyPriorityQueue();
    assertEquals(empty.hashCode(), emptyPQ.hashCode());
    assertNotEquals(newPQ.hashCode(), emptyPQ.hashCode());
  }

  @Test
  public void testEquals() {
    EmptyPriorityQueue empty = new EmptyPriorityQueue();
    assertEquals(emptyPQ, emptyPQ);
    assertEquals(empty, emptyPQ);
    assertNotEquals(null, empty);
    assertNotEquals(empty, null);
    assertNotEquals("empty", empty);
  }
}