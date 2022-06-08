package Problem1and2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BusTest {
  Bus bus;

  @Before
  public void setUp() throws Exception {
    bus = new Bus("1234", (float) 30.0, (float) 60.0);
  }

  @Test
  public void testToString() {
    String result = "{Bus: AbstractVehicle{vehicleID='1234', aveSpeed=30.0, maxSpeed=60.0}}";
    assertEquals(result, bus.toString());

    Bus bus1 = new Bus("1111", (float) 20.0, (float) 50.0);
    assertNotEquals(bus.toString(), bus1.toString());
  }
}