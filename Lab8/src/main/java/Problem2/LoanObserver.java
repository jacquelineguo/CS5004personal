package Problem2;

/**
 * Interface of LoanObserverImpl.
 */
public interface LoanObserver {

  /**
   * Update the loan, here is print it out.
   * @param observable - the loan need to be updated.
   */
  void update(Loan observable);

}
