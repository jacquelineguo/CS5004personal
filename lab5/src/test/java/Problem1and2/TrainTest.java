package Problem1and2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TrainTest {
  Train train;

  @Before
  public void setUp() throws Exception {
    train = new Train("1550",  (float) 60.0, (float) 70.0);
  }

  @Test
  public void testToString() {
    String result = "{Train: AbstractVehicle{vehicleID='1550', aveSpeed=60.0, maxSpeed=70.0}}";
    assertEquals(result, train.toString());

    Train train1 = new Train("1111", (float) 20.0, (float) 50.0);
    assertNotEquals(train1.toString(), train.toString());
  }
}