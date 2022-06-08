package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Pledges class represents the promised donation of a given amount at some point in the future.
 */
public class Pledges extends AbstractDonation{
  protected LocalDateTime promisedDate;

  /**
   * Constructor for Pledges class with donation amount, donation opened date, and promisedDate.
   * @param amount - the donation amount.
   * @param donationDate - the donation case opened date.
   * @param promisedDate - the date promised to make the donation.
   * @throws Exception if amount and donation are invalid, and promised date earlier
   * than donation date.
   */
  public Pledges(int amount, LocalDateTime donationDate, LocalDateTime promisedDate)
      throws Exception{
    super(amount, donationDate);

    if (promisedDate.isBefore(this.donationDate)) {
      throw new IllegalArgumentException("Promised date cannot before donation date.");
    }
    else {
      this.promisedDate = promisedDate;
    }
  }

  /**
   * Constructor for Pledges class with donation amount and donation date.
   * @param amount - the donation amount.
   * @param donationDate - the donation case opened date.
   * @throws Exception if the amount and donation date are invalid.
   */
  public Pledges(int amount, LocalDateTime donationDate) throws Exception {
    super(amount, donationDate);
  }

  /**
   * Get promised date.
   * @return get promised date.
   */
  public LocalDateTime getPromisedDate() {
    return this.promisedDate;
  }

  /**
   * Set a promised date.
   * @param promisedDate - the date promised to make the donation.
   * @throws IllegalArgumentException if the promised date is earlier than the donation
   * case opened date, or if the promised date is earlier than current date.
   */
  public void setPromisedDate(LocalDateTime promisedDate) throws IllegalArgumentException{
    if (promisedDate.isBefore(this.donationDate)) {
      throw new IllegalArgumentException("Promised date cannot earlier than donation date.");
    }
    if (promisedDate.isBefore(LocalDateTime.now())) {
      throw new IllegalArgumentException("Promised date must be in the future.");
    }
    this.promisedDate = promisedDate;
  }

  /**
   * Get the total donation of Pledges of a given year.
   * @param dueDate - the year to calculate the total donation of the year.
   * @return the total donation of Pledges of a given year.
   */
  @Override
  public int getDonation(LocalDateTime dueDate) {
    if (this.promisedDate.getYear() != dueDate.getYear()) {
      return 0;
    }
    return this.amount;
  }

  @Override
  public String toString() {
    return "Pledges{" +
        "amount=" + amount +
        ", donationDate=" + donationDate +
        ", promisedDate=" + promisedDate +
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
    Pledges pledges = (Pledges) o;
    return Objects.equals(promisedDate, pledges.promisedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), promisedDate);
  }
}
