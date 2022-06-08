package Problem1and2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TripReportTest {
  TripReport report;

  @Before
  public void setUp() throws Exception {
    report = new TripReport(new Boat("1110", (float) 20.0, (float) 30.0), (float) 28.0,
        (float) 60.0, 50);
  }

  @Test
  public void getVehicle() {
    assertEquals(new Boat("1110", (float) 20.0, (float) 30.0), report.getVehicle());
  }

  @Test
  public void getSpeed() {
    assertEquals(28.0, report.getSpeed(), 0.0);
  }

  @Test
  public void getDistance() {
    assertEquals(60.0, report.getDistance(), 0.0);
  }

  @Test
  public void getDuration() {
    Integer result = 50;
    assertEquals(result, report.getDuration());
  }

  @Test
  public void testEquals() {
    assertEquals(report, report);
    assertNotEquals(null, report);
    assertNotEquals("report", report);

    TripReport report1 = new TripReport(new Train("1110", (float) 20.0, (float) 30.0),
        (float) 28.0, (float) 60.0, 50);
    assertNotEquals(report1, report);

    TripReport report2 = new TripReport(new Boat("1110", (float) 20.0, (float) 30.0),
        (float) 28.0, (float) 60.0, 50);
    assertEquals(report, report2);

    TripReport report3 = new TripReport(new Boat("1110", (float) 20.0, (float) 30.0),
        (float) 30.0, (float) 60.0, 50);
    assertNotEquals(report3, report2);

  }

  @Test
  public void testHashCode() {
    TripReport report1 = new TripReport(new Train("1110", (float) 20.0, (float) 30.0),
        (float) 28.0, (float) 60.0, 50);
    assertEquals(report1.hashCode(), report.hashCode());

    TripReport report2 = new TripReport(new Boat("1110", (float) 20.0, (float) 30.0),
        (float) 28.0, (float) 60.0, 55);
    assertNotEquals(report.hashCode(), report2.hashCode());

  }

  @Test
  public void testToString() {
    String result = "TripReport{vehicle={Boat: AbstractVehicle{vehicleID='1110', aveSpeed=20.0, "
        + "maxSpeed=30.0}}, speed=28.0, distance=60.0, duration=50}";
    assertEquals(result, report.toString());

    TripReport report2 = new TripReport(new Boat("1110", (float) 20.0, (float) 30.0),
        (float) 28.0, (float) 60.0, 55);
    assertNotEquals(result, report2.toString());
  }
}