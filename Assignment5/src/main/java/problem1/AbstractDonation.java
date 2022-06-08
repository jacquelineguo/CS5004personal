package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * AbtractDonation class represents the donation made to non-profit organizations, it can be OneTime,
 * Monthly, or Pledges donations.
 */
public abstract class AbstractDonation {
  protected int amount;
  protected LocalDateTime donationDate;
  private static final int NONE = 0;

  /**
   * Constructor for AbtractDonation class.
   * @param amount - donation amount.
   * @param donationDate - donation date.
   * @throws InvalidMoneyAmountException if the donation amount smaller than or equal to 0.
   * @throws IllegalArgumentException - if the donation date is in the future.
   */
  public AbstractDonation(int amount, LocalDateTime donationDate)
      throws InvalidMoneyAmountException, IllegalArgumentException {
    if (amount <= NONE) {
      throw new InvalidMoneyAmountException();
    }
    else {
      this.amount = amount;
    }
    if (donationDate.isAfter(LocalDateTime.now())) {
      throw new IllegalArgumentException("Donation date cannot be in the future.");
    }
    else {
      this.donationDate = donationDate;
    }
  }

  /**
   * Get the total donation of the year of an organization.
   * @param dueDate - the year to calculate the total donation of the year.
   * @return the total donation of the year of an organization.
   */
  abstract int getDonation(LocalDateTime dueDate);

  @Override
  public String toString() {
    return "Donation{" +
        "amount=" + amount +
        ", donationDate=" + donationDate +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    AbstractDonation donation = (AbstractDonation) o;
    return amount == donation.amount && Objects.equals(donationDate, donation.donationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, donationDate);
  }
}
