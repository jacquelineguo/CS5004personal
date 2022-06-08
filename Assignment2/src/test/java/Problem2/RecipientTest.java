package Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecipientTest {
  Recipient msJ;

  @Before
  public void setUp() throws Exception {
    msJ = new Recipient("Alice", "Jackson", "ajackson@gmail.com");
  }

  @Test
  public void getFirstName() {
    assertEquals("Alice", msJ.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Jackson", msJ.getLastName());
  }

  @Test
  public void getName() {
    assertEquals("Alice Jackson", msJ.getName());
  }

  @Test
  public void getAddress() {
    assertEquals("ajackson@gmail.com", msJ.getAddress());
  }
}