package problem1;

import java.util.List;

public interface INonProfit {

  /**
   * Get the sum of all donations processed in the specified year.
   * @param year - year.
   * @return - the sum of all donations processed in the specified year.
   */
  int getTotalDonationsForYear(int year);

  /**
   * Add donation to the donation collection.
   * @param donation - new donation to be added.
   */
  void receiveDonation(AbstractDonation donation);

  /**
   * Delete donation from the collection.
   * @param donation - donation to be deleted.
   */
  void cancelDonation(AbstractDonation donation);

  /**
   * Get organization name.
   * @return the organization name.
   */
  String getOrgName();

  /**
   * Get donation collection.
   * @return the donation collection.
   */
  List<AbstractDonation> getDonations();

}
