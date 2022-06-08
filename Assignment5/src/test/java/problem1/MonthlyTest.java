package problem1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Before;
import org.junit.Test;

public class MonthlyTest {
  Monthly monthlyD;
  Monthly monthly;
  Monthly m;
  Monthly m1;

  LocalDateTime time1;
  LocalDateTime time2;
  LocalDateTime time3;
  LocalDateTime time4;
  LocalDateTime due;
  LocalDateTime due1;

  @Before
  public void setUp() throws Exception {
    due =
        LocalDateTime.of(2021, Month.DECEMBER, 31, 23, 59, 00);
    due1 =
        LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 00);
    time1 =
        LocalDateTime.of(2020, Month.DECEMBER, 1, 10, 30, 00);
    time2 =
        LocalDateTime.of(2020, Month.JULY, 1, 10, 30, 00);
    time3 =
        LocalDateTime.of(2020, Month.JULY, 15, 10, 30, 00);
    time4 =
        LocalDateTime.of(2019, Month.JULY, 5, 10, 30, 00);
    m = new Monthly(300, LocalDateTime.now());
    monthly = new Monthly(300, time1);
    monthlyD = new Monthly(20, time3);
    m1 = new Monthly(40, time4);
  }

  @Test
  public void setGetCancellationDate() {
    m.setCancellationDate(due);
    assertEquals(due, m.getCancellationDate());
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidSetCancelDate() throws Exception {
    monthlyD.setCancellationDate(time4);
  }

  @Test
  public void getDonation() {
    assertEquals(3600, monthly.getDonation(due));
    assertEquals(120, monthlyD.getDonation(due1));

    m1.setCancellationDate(due);
    assertEquals(480, m1.getDonation(due1));

    time1 =
        LocalDateTime.of(2020, Month.DECEMBER, 2, 23, 59, 00);
    due =
        LocalDateTime.of(2019, Month.DECEMBER, 31, 23, 59, 00);
    m1.setCancellationDate(time1);
    assertEquals(240, m1.getDonation(due));

    m1.setCancellationDate(time3);
    assertEquals(280, m1.getDonation(due1));

    m1.setCancellationDate(time2);
    assertEquals(240, m1.getDonation(due1));
    due =
        LocalDateTime.of(2021, Month.DECEMBER, 31, 23, 59, 00);
    assertEquals(0, m1.getDonation(due));

    LocalDateTime cancel =
        LocalDateTime.of(2020, Month.NOVEMBER, 25, 10, 30, 00);
    monthlyD.setCancellationDate(cancel);
    assertEquals(100, monthlyD.getDonation(due1));

    cancel =
        LocalDateTime.of(2020, Month.NOVEMBER, 10, 10, 30, 00);
    monthlyD.setCancellationDate(cancel);
    assertEquals(80, monthlyD.getDonation(due1));
  }

  @Test
  public void testToString() {
    String result = "Monthly{amount=40, donationDate=2019-07-05T10:30, cancellationDate=null}";
    assertEquals(result, m1.toString());
    assertNotEquals(result, monthlyD.toString());
  }

  @Test
  public void testEquals() throws Exception{
    assertEquals(m1, m1);
    assertNotEquals(null, m1);
    assertNotEquals(monthlyD, null);
    assertNotEquals(m1, monthlyD);
    assertNotEquals("Monthly", m1);

    Monthly m2 = new Monthly(40, time4);
    assertEquals(m2, m1);
    m1.setCancellationDate(time1);
    m2.setCancellationDate(time1);
    assertEquals(m2, m1);
    m2.setCancellationDate(due);
    assertNotEquals(m1, m2);
  }

  @Test
  public void testHashCode() throws Exception{
    monthly = new Monthly(40, time4);
    assertEquals(m1.hashCode(), monthly.hashCode());
    assertNotEquals(m1.hashCode(), monthlyD.hashCode());
  }
}