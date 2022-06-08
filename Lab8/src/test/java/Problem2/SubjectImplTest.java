package Problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class SubjectImplTest {
  Loan loan;
  Loan loan1;
  Loan loan2;
  LoanObserver observer;
  LoanObserver observer1;
  SubjectImpl observable;

  @Before
  public void setUp() throws Exception {
    loan = new Loan("school", 0.2);
    loan1 = new Loan("car", 0.6);
    loan2 = new Loan("house", 0.5);
    List<Loan> loans = new ArrayList<>();
    loans.add(loan);
    loans.add(loan1);
    List<Loan> loans1 = new ArrayList<>();
    loans1.add(loan2);
    observer = new LoanObserverImpl(loans);
    observer1 = new LoanObserverImpl(loans1);
    observable = new SubjectImpl(loan);
  }

  @Test
  public void registerObserver() {
    observable.registerObserver(observer);
    assertTrue(observable.getObservers().get(0).equals(observer));
  }

  @Test
  public void removeObserver() {
    observable.registerObserver(observer);
    observable.registerObserver(observer1);
    observable.removeObserver(observer);
    assertEquals(observable.getObservers().get(0), observer1);
  }

  @Test
  public void notifyObservers() {
    observable.registerObserver(observer);
    observable.registerObserver(observer1);
    observable.notifyObservers();
  }
}