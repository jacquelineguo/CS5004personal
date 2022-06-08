package Problem2;

import static org.junit.Assert.*;

import Problem1.ContactInfo;
import Problem1.Name;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class NonEmptySystemTest {
  EmptySystem emptySystem;
  NonEmptySystem system;
  LoanApplication application;
  LoanApplication application1;
  Name name;
  ContactInfo contactInfo;
  LocalDate submittedDate;

  @Before
  public void setUp() throws Exception {
    emptySystem = new EmptySystem();
    name = new Name("Jessica", "", "H");
    contactInfo = new ContactInfo(name, "66 AVE", "LA", "CA",
        "90045", "123", "jessicah@gmail.com", name);
    submittedDate = LocalDate.of(2010, 11, 11);
    application = new LoanApplication(name, name, contactInfo, "01", submittedDate,
        2000.0, 200.0, 10);
    application1 = new LoanApplication(name, name, contactInfo, "101", submittedDate,
        2000.0, 200.0, 16);
    system = new NonEmptySystem(application, null);
  }

  @Test
  public void count() {
    Integer result = 1;
    assertEquals(result, system.count());
  }

  @Test
  public void addApplication() {
    Integer result1 = 2;
    ILoanProcessingSystem system1 = system.addApplication(application1);
    assertEquals(result1, system1.count());
  }

  @Test
  public void checkPeriodIsGreater() throws Exception{
    assertFalse(system.checkPeriodIsGreater(application));

    ILoanProcessingSystem system1 = system.addApplication(application1);
    assertTrue(system1.checkPeriodIsGreater(application1));
  }

  @Test
  public void getApplication() throws Exception{
    assertEquals(application, system.getApplication("01"));
  }

  @Test (expected = InvalidLoanIDException.class)
  public void invalidIDTest() throws InvalidLoanIDException{
    system.getApplication("00");
  }
}