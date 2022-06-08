package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PosnTest {

  private Posn p;

  @Before
  public void setUp() throws Exception {
    p = new Posn(3, 4);
  }

  @Test
  public void getX() {
    assertEquals(3, p.getX(), 0);
  }

  @Test
  public void getY() {
    assertEquals(4, p.getY(), 0);
  }

  @Test
  public void testEquals() {
    Posn p1 = new Posn(1, 2);
    Posn p2 = new Posn(1, 2);
    Posn p3 = new Posn(1, 2);
    // reflexive
    assertTrue(p1.equals(p1));
    // symmetric
    assertTrue(p1.equals(p2) && p2.equals(p1));
    //transitive
    assertTrue(p1.equals(p2) && p2.equals(p3));
    assertTrue(p1.equals(p3));
    // consistant
    p1.getX();
    p2.getX();
    p1.getY();
    p2.getY();
    assertTrue(p1.equals(p2) && p2.equals(p1));

    assertFalse(p1.equals(null));
  }

  @Test
  public void testHashCode() {
    Posn p1 = new Posn(1, 2);
    Posn p2 = new Posn(1, 2);
    Posn p3 = new Posn(1, 3);

    p1.getX();
    p1.getY();
    assertEquals(p1.hashCode(), p1.hashCode());

    assertTrue(p1.equals(p2));
    assertEquals(p1.hashCode(), p2.hashCode());

    assertFalse(p1.equals(p3));
    assertNotEquals(p1.hashCode(), p3.hashCode());



  }

}