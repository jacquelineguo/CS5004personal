package Problem1;
/**
 * Represent Cleaning services class.
 */
public class Cleaning extends AbstractInterior{

  /**
   * Constructor for Cleaning class.
   * @param invoiceID - invoice ID of the service.
   * @param address - service address.
   * @param size - property size which could be small, medium, or large.
   * @param monthly - is a monthly service.
   * @param previousService - the previous service the property got.
   * @param numOfPets - number of pets in the property.
   */
  public Cleaning(String invoiceID, String address, PropertySize size, boolean monthly,
      Integer previousService, Integer numOfPets) {
    super(invoiceID, address, size, monthly, previousService, numOfPets);
  }

  /**
   * Calculates price for cleaning service.
   * @return the price for cleaning service.
   */
  @Override
  public double calculatePrice() {
    return giveDiscount(petCost(super.calculatePrice()));
  }

  @Override
  public String toString() {
    return "Cleaning: " + super.toString();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

}
