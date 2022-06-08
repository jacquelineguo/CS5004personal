package Problem1;

public interface Services {

  /**
   * Calculates the discount if it can be applied for monthly service discount or tenth service
   * discount.
   * @param price - total price.
   * @return - discounted price.
   */
  double giveDiscount(double price);

  /**
   * Get property size.
   * @return property size.
   */
  PropertySize getPropertySize();

  /**
   * Check if the service is a monthly service.
   * @return true if it's monthly service, false otherwise.
   */
  boolean isMonthly();

  /**
   * Get invoice ID.
   * @return invoice ID.
   */
  String getInvoiceID();

  /**
   * Get address.
   * @return service address.
   */
  String getAddress();

  /**
   * Get previous service number.
   * @return previous service number.
   */
  Integer getPreviousService();

  /**
   * Test the equality of another object to this service.
   * @param obj the object to test
   * @return true if equal, else false
   */
  boolean equals(Object obj);

  /**
   * Generates a hashcode for this service.
   * @return a hashcode
   */
  int hashCode();


  /**
   * Generates a string representation of this service.
   * @return a string representation of this service
   */
  String toString();
}
