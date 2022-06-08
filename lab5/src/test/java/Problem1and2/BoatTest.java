package Problem1and2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoatTest {
  Boat boat;

  @Before
  public void setUp() throws Exception {
    boat = new Boat("1110", (float) 20.0, (float) 55.0);
  }

  @Test
  public void getVehicleID() {
    assertEquals("1110", boat.getVehicleID());
  }

  @Test
  public void getAveSpeed() {
    assertEquals(20.0, boat.getAveSpeed(), 0.0);
  }

  @Test
  public void getMaxSpeed() {
    assertEquals(55.0, boat.getMaxSpeed(), 0.0);
  }

  @Test
  public void testEquals() {
    Boat boat1 = new Boat("1110", (float) 20.0, (float) 55.0);
    Boat boat2 = new Boat("1111", (float) 20.0, (float) 50.0);

    assertEquals(boat, boat);
    assertEquals(boat1, boat);
    assertNotEquals(null, boat);
    assertNotEquals("boat", boat);
    assertNotEquals(boat, boat2);
  }

  @Test
  public void testHashCode() {
    Boat boat1 = new Boat("1110", (float) 20.0, (float) 55.0);
    Boat boat2 = new Boat("1111", (float) 20.0, (float) 50.0);

    assertNotEquals(boat1.hashCode(), boat2.hashCode());
    assertEquals(boat1.hashCode(), boat.hashCode());
  }

  @Test
  public void testToString() {
    String result = "{Boat: AbstractVehicle{vehicleID='1110', aveSpeed=20.0, maxSpeed=55.0}}";
    assertEquals(result, boat.toString());

    Boat boat2 = new Boat("1111", (float) 20.0, (float) 50.0);
    assertNotEquals(boat2.toString(), boat.toString());
  }
}