package Problem2;

import java.util.Objects;

/**
 * Loan class represents a loan which has types and interest.
 */
public class Loan {
  private String type;
  private double interest;

  /**
   * Constructor for Loan.
   * @param type - type of the loan.
   * @param interest - interest of the loan.
   */
  public Loan(String type, double interest) {
    this.type = type;
    this.interest = interest;
  }

  /**
   * Get interest
   * @return interest
   */
  public double getInterest() {
    return interest;
  }

  /**
   * Set interest.
   * @param interest interest to be set.
   */
  public void setInterest(double interest) {
    this.interest = interest;
  }

  @Override
  public String toString() {
    return "Loan{" +
        "type='" + type + '\'' +
        ", interest=" + interest +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Loan)) {
      return false;
    }
    Loan loan = (Loan) o;
    return Double.compare(loan.getInterest(), getInterest()) == 0 && Objects
        .equals(type, loan.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, getInterest());
  }
}
