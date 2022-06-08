package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CleaningTest {
  private Cleaning cleaning;

  @Before
  public void setUp() throws Exception {
    cleaning = new Cleaning("1110", "65 N Ave", PropertySize.MEDIUM, true,
        3, 2);
  }

  @Test
  public void petCost() {
    assertEquals(151.2, cleaning.calculatePrice(), 0.1);

    cleaning = new Cleaning("1110", "65 N Ave", PropertySize.SMALL, false,
        3, 0);
    assertEquals(80.0, cleaning.calculatePrice(), 0.1);

    cleaning = new Cleaning("1110", "65 N Ave", PropertySize.LARGE, false,
        3, 4);
    assertEquals(342.4, cleaning.calculatePrice(), 0.01);
  }

  @Test
  public void testToString() {
    String result = "Cleaning: invoice=1110 address='65 N Ave' size=Medium is monthly=true"
        + " serviced=3 pets=2";
    assertEquals(result, cleaning.toString());
  }

  @Test
  public void testEquals() {
    assertEquals(cleaning, cleaning);
    assertNotEquals(null, cleaning);
    assertNotEquals("cleaning", cleaning);

    Cleaning cleaning1 = new Cleaning("1110", "65 N Ave", PropertySize.SMALL,
        false, 3, 0);
    assertNotEquals(cleaning1, cleaning);

    Cleaning cleaning2 = new Cleaning("1110", "65 N Ave", PropertySize.MEDIUM,
        true, 3, 2);
    assertEquals(cleaning, cleaning2);
  }

  @Test
  public void testHashCode() {
    Cleaning cleaning1 = new Cleaning("1110", "65 N Ave", PropertySize.SMALL,
        false, 3, 0);

    Cleaning cleaning2 = new Cleaning("1110", "65 N Ave", PropertySize.MEDIUM,
        true, 3, 2);
    assertEquals(cleaning.hashCode(), cleaning2.hashCode());
    assertNotEquals(cleaning.hashCode(), cleaning1.hashCode());
  }

  @Test
  public void isNegative() {
    assertEquals(false, cleaning.isNegative(cleaning.getPreviousService()));
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidPreviousService() throws IllegalArgumentException {
    cleaning = new Cleaning("1110", "65 N Ave", PropertySize.MEDIUM, true,
        -5, 2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidPetNum() throws Exception{
    cleaning = new Cleaning("1111", "65th Ave", PropertySize.SMALL,
        false, 5, -5);
  }

  @Test
  public void giveDiscount() {
    assertEquals(90.0, cleaning.giveDiscount(100.0), 0.0);

    cleaning = new Cleaning("1110", "65 N Ave", PropertySize.MEDIUM, true,
        19, 0);
    assertEquals(50.0, cleaning.giveDiscount(100.0), 0.0);

    cleaning = new Cleaning("1110", "65 N Ave", PropertySize.LARGE, false,
        29, 2);
    assertEquals(160.0, cleaning.giveDiscount(320.0), 0.0);

    cleaning = new Cleaning("1110", "65 N Ave", PropertySize.MEDIUM, true,
        3, 2);
    assertEquals(144.0, cleaning.giveDiscount(160.0), 0.0);
  }

  @Test
  public void getPropertySize() {
    assertEquals(PropertySize.MEDIUM, cleaning.getPropertySize());
  }

  @Test
  public void isMonthly() {
    assertEquals(true, cleaning.isMonthly());
  }

  @Test
  public void getInvoiceID() {
    assertEquals(cleaning.getInvoiceID(), "1110");
  }

  @Test
  public void getAddress() {
    assertEquals("65 N Ave", cleaning.getAddress());
  }

  @Test
  public void getPreviousService() {
    Integer result = 3;
    assertEquals(result, cleaning.getPreviousService());
  }

  @Test (expected = IllegalStateException.class)
  public void invalidPropertySize() throws IllegalStateException {
    Cleaning cleaning = new Cleaning("1234", "65th Ave", PropertySize.EMPTY,
        true, 49, 0);
    assertEquals(960.00, cleaning.calculatePrice(), 0.00);
  }
}