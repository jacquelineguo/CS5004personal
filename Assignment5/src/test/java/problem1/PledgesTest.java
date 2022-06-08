package problem1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Before;
import org.junit.Test;

public class PledgesTest {
  Pledges pledges;
  Pledges pledges1;
  Pledges pledges2;
  Pledges pledges3;
  LocalDateTime time1;
  LocalDateTime time2;
  LocalDateTime time3;
  LocalDateTime time4;
  LocalDateTime due;
  Pledges p;

  @Before
  public void setUp() throws Exception {
    due =
        LocalDateTime.of(2021, Month.DECEMBER, 31, 23, 59, 00);
    time1 =
        LocalDateTime.of(2020, Month.DECEMBER, 1, 10, 30, 00);
    time2 =
        LocalDateTime.of(2010, Month.DECEMBER, 1, 10, 30, 00);
    time3 =
        LocalDateTime.of(2021, Month.JULY, 1, 10, 30, 00);
    time4 =
        LocalDateTime.of(2010, Month.JULY, 1, 10, 30, 00);
    pledges = new Pledges(300, time1, time3);
    pledges1 = new Pledges(200, time4, time2);
    pledges2 = new Pledges(50, time2);
    pledges3 = new Pledges(60, LocalDateTime.now());
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidPromisedTime () throws Exception {
    pledges = new Pledges(300, time1, time2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidPromisedTime1 () throws Exception {
    pledges3 = new Pledges(30, time2, time4);
  }


  @Test
  public void setPromisedDate() {
    assertEquals(null, pledges2.getPromisedDate());
    pledges2.setPromisedDate(time3);
    assertEquals(time3, pledges2.getPromisedDate());
    time4 = LocalDateTime.of(2021, Month.AUGUST, 1, 10, 30, 00);
    pledges3.setPromisedDate(time4);
    assertEquals(time4, pledges3.getPromisedDate());
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidSetPromisedDate() throws Exception{
    pledges2.setPromisedDate(time4);
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidSetPromisedDate1() throws Exception{
    pledges.setPromisedDate(time1);
  }

  @Test
  public void getDonation() {
    assertEquals(0, pledges1.getDonation(due));
    assertEquals(300, pledges.getDonation(due));
  }

  @Test
  public void testGetPromisedDate() {
    assertEquals(time3, pledges.getPromisedDate());
  }

  @Test
  public void testToString() {
    String result =
        "Pledges{amount=200, donationDate=2010-07-01T10:30, promisedDate=2010-12-01T10:30}";
    assertEquals(result, pledges1.toString());
    assertNotEquals(pledges.toString(), pledges1.toString());
  }

  @Test
  public void testEquals() throws Exception{
    assertEquals(pledges, pledges);
    assertNotEquals(null, pledges);
    assertNotEquals(pledges, null);
    assertNotEquals("Pledges", pledges);

    Pledges pledges6 = new Pledges(300, time1, time3);
    assertEquals(pledges6, pledges);
    assertNotEquals(pledges, pledges2);
  }

  @Test
  public void testHashCode() throws Exception{
    Pledges pledges6 = new Pledges(300, time1, time3);
    assertEquals(pledges6.hashCode(), pledges.hashCode());
    assertNotEquals(pledges.hashCode(), pledges1.hashCode());
  }
}