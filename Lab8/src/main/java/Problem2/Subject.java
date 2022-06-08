package Problem2;

/**
 * Interface of Observable of Loan.
 */
public interface Subject {

  /**
   * Register an observer.
   * @param observer - the observer need to be add.
   */
  void registerObserver(LoanObserver observer);

  /**
   * Remove an observer.
   * @param observer - the observer to be removed.
   */
  void removeObserver(LoanObserver observer);

  /**
   * Notify observer.
   */
  void notifyObservers();
}
