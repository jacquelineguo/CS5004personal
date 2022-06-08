package Problem2;

import static org.junit.Assert.*;

import Problem1.ContactInfo;
import Problem1.Name;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class EmptySystemTest {
  EmptySystem emptySystem;
  NonEmptySystem system;
  LoanApplication application;
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
  }

  @Test
  public void count() {
    Integer result = 0;
    assertEquals(result, emptySystem.count());
  }

  @Test
  public void addApplication() {
    system = new NonEmptySystem(application, null);
    assertTrue(system.equals(emptySystem.addApplication(application)));
  }

  @Test (expected = LoanApplicationNotFoundException.class)
  public void checkPeriodIsGreater() throws LoanApplicationNotFoundException{
    emptySystem.checkPeriodIsGreater(application);
  }

  @Test (expected = InvalidLoanIDException.class)
  public void getApplication() throws InvalidLoanIDException{
    emptySystem.getApplication("01");
  }
}