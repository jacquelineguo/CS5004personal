package Problem2;

import java.time.LocalDate;

/**
 * ILoanProcessingSystem represents the interface of an ADT LoanProcessingSystem, which will be
 * used to store and process the received loan applications.
 */
public interface ILoanProcessingSystem {

  /**
   * Check whether or not the LoanProcessingSystem is empty.
   * @return true if it's empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Count the number of LoanApplications in the LoanProcessingSystem.
   * @return the number of LoanApplications in the LoanProcessingSystem.
   */
  Integer count();

  /**
   * Add a LoanApplication to the LoanProcessingSystem. (LoanProcessingSystem does allow duplicate
   * LoanApplications)
   * @param application - application to be added.
   * @return ILoanProcessingSystem with added application.
   */
  ILoanProcessingSystem addApplication(LoanApplication application);

  /**
   * Remove a specified LoanApplication from the LoanProcessingSystem.
   * @param application - the application to be removed.
   * @return ILoanProcessingSystem with removed application.
   * @throws LoanApplicationNotFoundException if application does not in the LoanProcessingSystem.
   */
  ILoanProcessingSystem removeApplication(LoanApplication application) throws
      LoanApplicationNotFoundException;

  /**
   * Check if a specified LoanApplication in the LoanProcessingSystem was submitted on a specified
   * date.
   * @param application - the application to be checked.
   * @param date - the submitted date to be checked.
   * @return true if a specified LoanApplication in the LoanProcessingSystem was submitted on a
   * specified date, false otherwise.
   * @throws LoanApplicationNotFoundException if the application does not in the
   * LoanProcessingSystem.
   */
  Boolean checkSubmittedDate(LoanApplication application, LocalDate date)
      throws LoanApplicationNotFoundException;

  /**
   * Check if a specified LoanApplication in the LoanProcessingSystem has the expected loan
   * repayment period greater than 15 years.
   * @param application - the application to be checked.
   * @return true if the expected loan repayment period greater than 15 years, false otherwise.
   * @throws LoanApplicationNotFoundException if the application not found.
   */
  Boolean checkPeriodIsGreater(LoanApplication application) throws LoanApplicationNotFoundException;

  /**
   * Check if a specified LoanApplication in the LoanProcessingSystem has the annual interest rate
   * greater than the specified interest rate.
   * @param application - the application to be checked.
   * @param rate - the specified interest rate to be compared.
   * @return true if a specified LoanApplication in the LoanProcessingSystem has the annual interest
   * rate greater than the specified interest rate, false otherwise.
   * @throws LoanApplicationNotFoundException if the application not found.
   */
  Boolean checkInterestIsGreater(LoanApplication application, Double rate) throws
      LoanApplicationNotFoundException;

  /**
   * Find and return all LoanApplications from the LoanProcessingSystem where the requested amount
   * is less than $25000 per year.
   * @return all LoanApplications from the LoanProcessingSystem where the requested amount is less
   * than $25000 per year.
   * @throws LoanApplicationNotFoundException if the application not found.
   */
  ILoanProcessingSystem findApplicationsAmountLessThan() throws LoanApplicationNotFoundException;

  /**
   * Get a LoanApplication from the LoanProcessingSystem based upon the LoanApplications’s unique
   * identifier, loanID.
   * @param loanID - the application loanID.
   * @return the LoanApplication from the LoanProcessingSystem based upon the LoanApplications’s
   * unique identifier, loanID.
   * @throws InvalidLoanIDException if application not found.
   */
  LoanApplication getApplication(String loanID) throws InvalidLoanIDException;
}
