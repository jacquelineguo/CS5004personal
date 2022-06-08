package problem1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Before;
import org.junit.Test;

public class OneTimeTest {
  OneTime don1;
  OneTime don2;
  LocalDateTime time1;
  LocalDateTime time2;

  @Before
  public void setUp() throws Exception {
    time1 =
        LocalDateTime.of(2020, Month.DECEMBER, 1, 10, 30, 00);
    time2 =
        LocalDateTime.of(2010, Month.DECEMBER, 1, 10, 30, 00);
    don1 = new OneTime(300, time1);
    don2 = new OneTime(20, time2);
  }

  @Test
  public void getDonation() {
    LocalDateTime due =
        LocalDateTime.of(2020, 12, 31, 23, 59, 00);
    assertEquals(300, don1.getDonation(due));
    assertEquals(0, don2.getDonation(due));
  }

  @Test (expected = InvalidMoneyAmountException.class)
  public void invalidMoney() throws Exception{
    don1 = new OneTime(0, time1);
    don2 = new OneTime(-10, time2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidTime() throws Exception {
    time1 =
        LocalDateTime.of(2021, Month.DECEMBER, 1, 10, 30, 00);
    don1 = new OneTime(300, time1);
  }

  @Test
  public void testToString() {
    String result = "OneTime{amount=300, donationDate=2020-12-01T10:30}";
    assertEquals(result, don1.toString());
    assertNotEquals(result, don2.toString());
  }

  @Test
  public void testEquals() {
    assertEquals(don1, don1);
    assertNotEquals(null, don1);
    assertNotEquals("Onetime", don1);
    assertNotEquals(don1, don2);
  }

  @Test
  public void testHashCode() throws Exception{
    OneTime don3 = new OneTime(300, time1);
    assertNotEquals(don1.hashCode(), don2.hashCode());
    assertEquals(don3, don1);
    assertNotEquals(don1.hashCode(), don2.hashCode());
  }
}