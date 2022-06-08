package problem1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class NonProfitTest {
  NonProfit nonProfit1;
  NonProfit nonProfit2;
  LocalDateTime time1;
  LocalDateTime time2;
  LocalDateTime time3;
  List<AbstractDonation> donations;

  @Before
  public void setUp() throws Exception {
    time1 =
        LocalDateTime.of(2021, Month.JANUARY, 1, 10, 30, 00);
    time2 =
        LocalDateTime.of(2019, Month.DECEMBER, 1, 10, 30, 00);
    time3 =
        LocalDateTime.of(2021, Month.FEBRUARY, 1, 10, 30, 00);
    AbstractDonation donation = new OneTime(20, time1);
    AbstractDonation donation1 = new Monthly(40, time2);
    AbstractDonation donation2 = new Pledges(400, time2, time3);
    donations = new ArrayList<AbstractDonation>();
    donations.add(donation);
    donations.add(donation1);
    donations.add(donation2);
    nonProfit1 = new NonProfit("A", donations);
    List<AbstractDonation> donations1 = new ArrayList<AbstractDonation>();
    donations1.add(donation);
    donations1.add(donation1);
    donations1.add(donation2);
    nonProfit2 = new NonProfit("A", donations1);
  }

  @Test
  public void getTotalDonationsForYear() {
    assertEquals(900, nonProfit1.getTotalDonationsForYear(2021));
    assertEquals(480, nonProfit1.getTotalDonationsForYear(2020));
  }

  @Test
  public void receiveDonation() throws Exception{
    assertEquals(nonProfit1, nonProfit2);
    AbstractDonation donation3 = new OneTime(50, time1);
    nonProfit2.receiveDonation(donation3);
    nonProfit1.receiveDonation(donation3);
    assertEquals(nonProfit1, nonProfit2);
  }

  @Test
  public void cancelDonation() throws Exception{
    AbstractDonation donation3 = new OneTime(50, time1);
    nonProfit1.receiveDonation(donation3);
    nonProfit1.cancelDonation(donation3);
    assertEquals(nonProfit1, nonProfit2);
  }

  @Test
  public void testToString() throws Exception{
    String result = "NonProfit{orgName='A', donations=[OneTime{amount=20, "
        + "donationDate=2021-01-01T10:30}, Monthly{amount=40, donationDate=2019-12-01T10:30, "
        + "cancellationDate=null}, Pledges{amount=400, donationDate=2019-12-01T10:30, "
        + "promisedDate=2021-02-01T10:30}]}";
    assertEquals(result, nonProfit2.toString());
    AbstractDonation donation = new OneTime(20, time1);
    nonProfit1.cancelDonation(donation);
    assertNotEquals(nonProfit1, nonProfit2);
  }

  @Test
  public void testEquals() throws Exception{
    assertEquals(nonProfit1, nonProfit1);
    assertEquals(nonProfit1, nonProfit2);
    assertNotEquals(nonProfit1, null);
    assertNotEquals(null, nonProfit1);
    AbstractDonation donation3 = new OneTime(50, time1);
    nonProfit1.receiveDonation(donation3);
    assertNotEquals(nonProfit1, nonProfit2);
    assertNotEquals("nonprofit", nonProfit1);
    nonProfit1 = new NonProfit("B", donations);
    assertNotEquals(nonProfit1, nonProfit2);
  }

  @Test
  public void testHashCode1() throws Exception{
    assertEquals(nonProfit1.hashCode(), nonProfit2.hashCode());
    AbstractDonation donation = new OneTime(20, time1);
    nonProfit1.cancelDonation(donation);
    assertNotEquals(nonProfit1, nonProfit2);
  }
}