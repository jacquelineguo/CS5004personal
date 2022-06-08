package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Monthly class represents the monthly donations.
 */
public class Monthly extends AbstractDonation{
  protected LocalDateTime cancellationDate;
  protected static final int MONTH_PER_YEAR = 12;
  protected static final int ONE_MONTH = 1;

  /**
   * Constructor for Monthly donations.
   * @param amount - the monthly donate amount.
   * @param donationDate - the monthly donation date.
   * @throws Exception if the amount and donation date are invalid.
   */
  public Monthly(int amount, LocalDateTime donationDate) throws Exception{
    super(amount, donationDate);
  }

  /**
   * Set a cancellation date to cancel the monthly donation.
   * @param cancellationDate - the date to cancel the monthly donation.
   * @throws IllegalArgumentException if the cancellation date is earlier than the donation date.
   */
  public void setCancellationDate(LocalDateTime cancellationDate) throws IllegalArgumentException {
    if (cancellationDate.isBefore(this.donationDate)) {
      throw new IllegalArgumentException("Cancellation date cannot before donation date.");
    }
    else {
      this.cancellationDate = cancellationDate;
    }
  }

  /**
   * Get cancellation date.
   * @return the cancellation date.
   */
  public LocalDateTime getCancellationDate() {
    return this.cancellationDate;
  }

  /**
   * Get the total amount of monthly donation in a given year.
   * @param dueDate - the year to calculate the total donation of the year.
   * @return the total amount of monthly donation in a given year.
   */
  @Override
  public int getDonation(LocalDateTime dueDate) {
    if (this.donationDate.isBefore(dueDate)) {
      if (this.cancellationDate == null) {
        if (this.donationDate.getYear() == dueDate.getYear()) {
          return this.amount * (MONTH_PER_YEAR - this.donationDate.getMonthValue() + ONE_MONTH);
        }
        else {
          return this.amount * MONTH_PER_YEAR;
        }
      }
      else {
        if (cancellationDate.getYear() > dueDate.getYear()) {
          if (this.donationDate.getYear() == dueDate.getYear()) {
            return this.amount * (MONTH_PER_YEAR - this.donationDate.getMonthValue() + ONE_MONTH);
          }
          else {
            return this.amount * MONTH_PER_YEAR;
          }
        }
        else if (cancellationDate.getYear() == dueDate.getYear()) {
          if (this.donationDate.getYear() < this.cancellationDate.getYear()) {
            // eg. donation - 2019/11/20 cancel - 2020/10/25 due - 2020/12/31
            if (this.donationDate.getDayOfMonth() < this.cancellationDate.getDayOfMonth()) {
              return this.amount * this.cancellationDate.getMonthValue();
            }
            else { // eg. donation - 2019/11/20 | cancel - 2020/5/15 | due - 2020/12/31
              return this.amount * (this.cancellationDate.getMonthValue() - ONE_MONTH);
            }
          }
          else { // donation year == cancellation year
            // donation - 2020/1/20 cancel - 2020/5/25 due - 2020/12/31
            if (this.donationDate.getDayOfMonth() < this.cancellationDate.getDayOfMonth()) {
              return this.amount * (this.cancellationDate.getMonthValue()
                  - this.donationDate.getMonthValue() + ONE_MONTH);
            }
            else {
              return this.amount *
                  (this.cancellationDate.getMonthValue() - this.donationDate.getMonthValue());
            }
          }
        }
      }
    }
    return 0;
  }

  @Override
  public String toString() {
    return "Monthly{" +
        "amount=" + amount +
        ", donationDate=" + donationDate +
        ", cancellationDate=" + cancellationDate +
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
    if (!super.equals(o)) {
      return false;
    }
    Monthly monthly = (Monthly) o;
    if (this.cancellationDate != null) {
      return Objects.equals(cancellationDate, monthly.cancellationDate);
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), cancellationDate);
  }
}
