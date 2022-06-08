package problem1;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Objects;

/**
 * NonProfit class represents a non-profit organization.
 */
public class NonProfit {
  private String orgName;
  private List<AbstractDonation> donations;

  /**
   * Constructor for NonProfit class.
   * @param orgName - organization name.
   * @param donations - a collection of organization donations.
   */
  public NonProfit(String orgName, List<AbstractDonation> donations) {
    this.orgName = orgName;
    this.donations = donations;
  }

  /**
   * Get the sum of all donations processed in the specified year.
   * @param year - year.
   * @return - the sum of all donations processed in the specified year.
   */
  public int getTotalDonationsForYear(int year) {
    LocalDateTime dueDate = convertYear(year);
    int totalDonation = 0;
    for (AbstractDonation donation : this.donations) {
      totalDonation += donation.getDonation(dueDate);
    }
    return totalDonation;
  }

  /**
   * Helper function to convert integer year to LocalDateTime.
   * @param year - year.
   * @return converted year.
   */
  private LocalDateTime convertYear(int year) {
    LocalDateTime dueDate =
        LocalDateTime.of(year, Month.DECEMBER, 31,23, 59);
    return dueDate;
  }

  /**
   * Add donation to the donation collection.
   * @param donation - new donation to be added.
   */
  public void receiveDonation(AbstractDonation donation) {
    this.donations.add(donation);
  }

  /**
   * Delete donation from the collection.
   * @param donation - donation to be deleted.
   */
  public void cancelDonation(AbstractDonation donation) {
    if (donation != null) {
      this.donations.remove(donation);
    }
  }

  /**
   * Get organization name.
   * @return the organization name.
   */
  public String getOrgName() {
    return this.orgName;
  }

  /**
   * Get donation collection.
   * @return the donation collection.
   */
  public List<AbstractDonation> getDonations() {
    return this.donations;
  }

  @Override
  public String toString() {
    return "NonProfit{" +
        "orgName='" + orgName + '\'' +
        ", donations=" + donations +
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
    NonProfit nonProfit = (NonProfit) o;
    return this.getOrgName() == nonProfit.getOrgName() &&
        this.donations.equals(nonProfit.getDonations());
  }

  @Override
  public int hashCode() {
    return Objects.hash(orgName, donations);
  }
}
