package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;

public class PastaTest {
  Pasta p;
  @Before
  public void setUp() throws Exception {
    p = new Pasta("Italian Pasta", 16.0, 36);
  }
}