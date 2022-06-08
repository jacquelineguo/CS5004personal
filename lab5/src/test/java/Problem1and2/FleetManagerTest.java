package Problem1and2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FleetManagerTest {
  FleetManager manager;

  @Before
  public void setUp() throws Exception {
    manager = new FleetManager();
  }

  @Test
  public void drive() {
    Boat boat = new Boat("1110", (float) 20.0, (float) 55.0);
    TripReport report = manager.drive((float) 100.0, boat);

    assertEquals(boat, report.getVehicle());
    assertEquals((float) 20.0, report.getSpeed(), 0.0);
    assertEquals((float) 100.0, report.getDistance(), 0.0);
    assertEquals((float) 5.0, report.getDuration(), 0.0);
  }

  @Test
  public void testDrive1() {
    Bus bus = new Bus("1110", (float) 30.0, (float) 55.0);
    TripReport report = manager.drive((float) 120.0, bus);

    assertEquals(bus, report.getVehicle());
    assertEquals((float) 30.0, report.getSpeed(), 0.0);
    assertEquals((float) 120.0, report.getDistance(), 0.0);
    assertEquals((float) 4.0, report.getDuration(), 0.0);
  }

  @Test
  public void testDrive() {
    Train train = new Train("1110", (float) 30.0, (float) 55.0);
    TripReport report = manager.drive((float) 120.0, train);

    assertEquals(train, report.getVehicle());
    assertEquals((float) 30.0, report.getSpeed(), 0.0);
    assertEquals((float) 120.0, report.getDistance(), 0.0);
    assertEquals((float) 4.0, report.getDuration(), 0.0);
  }

  @Test
  public void testDrive2() {
    AbstractVehicle vehicle = new Train("1110", (float) 30.0, (float) 55.0);
    TripReport report = manager.drive((float) 120.0, vehicle);

    assertEquals(vehicle, report.getVehicle());
    assertEquals((float) 30.0, report.getSpeed(), 0.0);
    assertEquals((float) 120.0, report.getDistance(), 0.0);
    assertEquals((float) 4.0, report.getDuration(), 0.0);
  }

  @Test
  public void testDrive3() {
    AbstractVehicle vehicle = new Train("1110", (float) 30.0, (float) 50.0);
    TripReport report = manager.drive((float) 120.0, vehicle, (float) 40.0);
    assertEquals((float) 3.0, report.getDuration(), 0.0);

    TripReport report1 = manager.drive((float) 100.0, vehicle, (float) 60.0);
    assertEquals((float) 2.0, report1.getDuration(), 0.0);
  }
}