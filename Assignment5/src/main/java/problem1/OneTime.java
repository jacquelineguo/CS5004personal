package problem1;

import java.time.LocalDateTime;

/**
 * OneTime class represents the one-time donation.
 */
public class OneTime extends AbstractDonation{

  /**
   * Constructor for OneTime donation.
   * @param amount - the donation amount.
   * @param donationDate - the donation date.
   * @throws Exception if the donation amount and date are invalid.
   */
  public OneTime(int amount, LocalDateTime donationDate) throws Exception{
    super(amount, donationDate);
  }

  /**
   * Calculate the total one-time donation in the year.
   * @param dueDate - the year to calculate the total donation of the year.
   * @return the total one-time donation in the year.
   */
  @Override
  public int getDonation(LocalDateTime dueDate) {
    if (this.donationDate.getYear() == dueDate.getYear()) {
      return this.amount;
    }
    return 0;
  }

  @Override
  public String toString() {
    return "OneTime{" +
        "amount=" + amount +
        ", donationDate=" + donationDate +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
