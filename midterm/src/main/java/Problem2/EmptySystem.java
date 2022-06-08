package Problem2;

import java.time.LocalDate;

public class EmptySystem implements ILoanProcessingSystem {
  private static final Integer EMPTY = 0;

  public EmptySystem() {
  }

  /**
   * Check whether or not the LoanProcessingSystem is empty.
   *
   * @return true if it's empty, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * Count the number of LoanApplications in the LoanProcessingSystem.
   *
   * @return the number of LoanApplications in the LoanProcessingSystem.
   */
  @Override
  public Integer count() {
    return EMPTY;
  }

  /**
   * Add a LoanApplication to the LoanProcessingSystem. (LoanProcessingSystem does allow duplicate
   * LoanApplications)
   *
   * @param application - application to be added.
   * @return ILoanProcessingSystem with added application.
   */
  @Override
  public ILoanProcessingSystem addApplication(LoanApplication application) {
    return new NonEmptySystem(application, null);
  }

  /**
   * Remove a specified LoanApplication from the LoanProcessingSystem.
   *
   * @return ILoanProcessingSystem with removed application.
   * @throws LoanApplicationNotFoundException if application does not in the LoanProcessingSystem.
   */
  @Override
  public ILoanProcessingSystem removeApplication(LoanApplication application)
      throws LoanApplicationNotFoundException {
    throw new LoanApplicationNotFoundException();
  }

  /**
   * Check if a specified LoanApplication in the LoanProcessingSystem was submitted on a specified
   * date.
   *
   * @param application - the application to be checked.
   * @param date - the submitted date to be checked.
   * @return true if a specified LoanApplication in the LoanProcessingSystem was submitted on a
   * specified date, false otherwise.
   * @throws LoanApplicationNotFoundException if the application does not in the
   * LoanProcessingSystem.
   */
  @Override
  public Boolean checkSubmittedDate(LoanApplication application, LocalDate date)
      throws LoanApplicationNotFoundException {
    throw new LoanApplicationNotFoundException();
  }

  /**
   * Check if a specified LoanApplication in the LoanProcessingSystem has the expected loan
   * repayment period greater than 15 years.
   * @param application - the application to be checked.
   * @return true if the expected loan repayment period greater than 15 years, false otherwise.
   * @throws LoanApplicationNotFoundException if the application not found.
   */
  @Override
  public Boolean checkPeriodIsGreater(LoanApplication application) throws
      LoanApplicationNotFoundException {
    throw new LoanApplicationNotFoundException();
  }

  /**
   * Check if a specified LoanApplication in the LoanProcessingSystem has the annual interest rate
   * greater than the specified interest rate.
   * @param application - the application to be checked.
   * @param rate - the specified interest rate to be compared.
   * @return true if a specified LoanApplication in the LoanProcessingSystem has the annual interest
   * rate greater than the specified interest rate, false otherwise.
   * @throws LoanApplicationNotFoundException if the application not found.
   */
  @Override
  public Boolean checkInterestIsGreater(LoanApplication application, Double rate) throws
      LoanApplicationNotFoundException {
    throw new LoanApplicationNotFoundException();
  }

  /**
   * Find and return all LoanApplications from the LoanProcessingSystem where the requested amount
   * is less than $25000 per year.
   * @return all LoanApplications from the LoanProcessingSystem where the requested amount is less
   * than $25000 per year.
   * @throws LoanApplicationNotFoundException if the application not found.
   */
  @Override
  public ILoanProcessingSystem findApplicationsAmountLessThan()
      throws LoanApplicationNotFoundException {
    throw new LoanApplicationNotFoundException();
  }

  /**
   * Get a LoanApplication from the LoanProcessingSystem based upon the LoanApplications’s unique
   * identifier, loanID.
   * @param loanID - the application loanID.
   * @return the LoanApplication from the LoanProcessingSystem based upon the LoanApplications’s
   * unique identifier, loanID.
   * @throws InvalidLoanIDException if ID doesn't exist.
   */
  @Override
  public LoanApplication getApplication(String loanID) throws InvalidLoanIDException {
    throw new InvalidLoanIDException();
  }
}
