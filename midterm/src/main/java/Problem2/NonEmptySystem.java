package Problem2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class NonEmptySystem implements ILoanProcessingSystem {
  private LoanApplication first;
  private ILoanProcessingSystem rest;
  private static final Integer ONE = 1;
  private static final Integer PERIOD_BOUND = 15;
  private static final Double AMOUNT_BOUND = 25000.0;

  /**
   * Constructor for NonEmptySystem.
   * @param first - first element in the NonEmptySystem.
   * @param rest - rest elements in the NonEmptySystem.
   */
  public NonEmptySystem(LoanApplication first, ILoanProcessingSystem rest) {
    this.first = first;
    this.rest = rest;
  }

  /**
   * Check whether or not the LoanProcessingSystem is empty.
   *
   * @return true if it's empty, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }

  /**
   * Count the number of LoanApplications in the LoanProcessingSystem.
   *
   * @return the number of LoanApplications in the LoanProcessingSystem.
   */
  @Override
  public Integer count() {
    if (!this.isEmpty() && this.rest == null) {
      return ONE;
    }
    return ONE + this.rest.count();
  }

  /**
   * Add a LoanApplication to the LoanProcessingSystem. (LoanProcessingSystem does allow duplicate
   * LoanApplications)
   *
   * @return ILoanProcessingSystem with added application.
   */
  @Override
  public ILoanProcessingSystem addApplication(LoanApplication application) {
    if (this.rest == null) {
      NonEmptySystem temp = new NonEmptySystem(application, null);
      return new NonEmptySystem(this.first, temp);
    }
    return new NonEmptySystem(this.first, this.rest.addApplication(application));
  }

  /**
   * Remove a specified LoanApplication from the LoanProcessingSystem.
   *
   * @return ILoanProcessingSystem with removed application.
   * @throws LoanApplicationNotFoundException if application does not in the LoanProcessingSystem.
   */
  @Override
  public ILoanProcessingSystem removeApplication(LoanApplication application) throws
      LoanApplicationNotFoundException {
    if (this.first.equals(application)) {
      return this.rest;
    }
    return new NonEmptySystem(this.first, this.rest.removeApplication(application));
  }

  /**
   * Check if a specified LoanApplication in the LoanProcessingSystem was submitted on a specified
   * date.
   *
   * @param application - the application to be checked.
   * @param date        - the submitted date to be checked.
   * @return true if a specified LoanApplication in the LoanProcessingSystem was submitted on a
   * specified date, false otherwise.
   * @throws LoanApplicationNotFoundException if the application does not in the
   * LoanProcessingSystem.
   */
  @Override
  public Boolean checkSubmittedDate(LoanApplication application, LocalDate date)
      throws LoanApplicationNotFoundException {
    if (this.first.equals(application) && this.first.getDateLoanSubmitted().equals(date)) {
      return true;
    }
    return this.rest.checkSubmittedDate(application, date);
  }

  /**
   * Check if a specified LoanApplication in the LoanProcessingSystem has the expected loan
   * repayment period greater than 15 years.
   *
   * @param application - the application to be checked.
   * @return true if the expected loan repayment period greater than 15 years, false otherwise.
   * @throws LoanApplicationNotFoundException if the application not found.
   */
  @Override
  public Boolean checkPeriodIsGreater(LoanApplication application)
      throws LoanApplicationNotFoundException {
    if (this.rest == null) {
      return this.first.equals(application) && this.first.getLoanDurationInYears() > PERIOD_BOUND;
    }
    return this.rest.checkPeriodIsGreater(application);
  }

  /**
   * Check if a specified LoanApplication in the LoanProcessingSystem has the annual interest rate
   * greater than the specified interest rate.
   *
   * @param application - the application to be checked.
   * @param rate        - the specified interest rate to be compared.
   * @return true if a specified LoanApplication in the LoanProcessingSystem has the annual interest
   * rate greater than the specified interest rate, false otherwise.
   * @throws LoanApplicationNotFoundException if the application not found.
   */
  @Override
  public Boolean checkInterestIsGreater(LoanApplication application, Double rate) throws
      LoanApplicationNotFoundException{
    if (this.first.equals(application) && this.first.getAnnualAPR() > rate) {
      return true;
    }
    return this.rest.checkInterestIsGreater(application, rate);
  }

  /**
   * Find and return all LoanApplications from the LoanProcessingSystem where the requested amount
   * is less than $25000 per year.
   *
   * @return all LoanApplications from the LoanProcessingSystem where the requested amount is less
   * than $25000 per year.
   * @throws LoanApplicationNotFoundException if the application not found.
   */
  @Override
  public ILoanProcessingSystem findApplicationsAmountLessThan()
      throws LoanApplicationNotFoundException {
    if (this.rest == null) {
      if (this.first.getRequestedAmount() < AMOUNT_BOUND) {
        return new NonEmptySystem(this.first, null);
      }
    }
    if (this.first.getRequestedAmount() < AMOUNT_BOUND) {
      return new NonEmptySystem(this.first, this.rest.findApplicationsAmountLessThan());
    }
    return new EmptySystem();
  }

  /**
   * Get a LoanApplication from the LoanProcessingSystem based upon the LoanApplications’s unique
   * identifier, loanID.
   *
   * @param loanID - the application loanID.
   * @return the LoanApplication from the LoanProcessingSystem based upon the LoanApplications’s
   * unique identifier, loanID.
   * @throws InvalidLoanIDException if application not found.
   */
  @Override
  public LoanApplication getApplication(String loanID) throws InvalidLoanIDException {
    if (this.rest == null) {
      if (this.first.getLoanID().equals(loanID)) {
        return this.first;
      }
      throw new InvalidLoanIDException();
    }
    return this.rest.getApplication(loanID);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    NonEmptySystem that = (NonEmptySystem) o;
    return Objects.equals(first, that.first) && Objects.equals(rest, that.rest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, rest);
  }
}
