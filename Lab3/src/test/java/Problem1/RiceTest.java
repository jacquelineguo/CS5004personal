package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;

public class RiceTest {
  Rice blackRice;

  @Before
  public void setUp() throws Exception {
    blackRice = new Rice("Black Rice", 40, 70);
  }
}