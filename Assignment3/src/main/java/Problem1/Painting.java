package Problem1;

/**
 * Represent Painting services class.
 */
public class Painting extends AbstractInterior{
  private static final Integer TIME_LOWER = 16;
  private static final Integer TIME_UPPER = 24;

  /**
   * Constructor for Painting class.
   * @param invoiceID - invoice ID of the service.
   * @param address - service address.
   * @param size - property size which could be small, medium, or large.
   * @param monthly - is a monthly service.
   * @param previousService - the previous service the property got.
   * @param numOfPets - number of pets in the property.
   */
  public Painting(String invoiceID, String address, PropertySize size, boolean monthly,
      Integer previousService, Integer numOfPets) {
    super(invoiceID, address, size, monthly, previousService, numOfPets);
  }

  /**
   * Calculates the painting service price.
   * @return the painting service price.
   * @throws IllegalStateException if the property size is invalid.
   */
  public double calculatePrice() throws IllegalStateException{
    double price;
    switch(getPropertySize()) {
      case SMALL:
      case MEDIUM:
        price = PRICE_PER_HR * TIME_LOWER;
        break;
      case LARGE:
        price = PRICE_PER_HR * TIME_UPPER;
        break;
      default:
        throw new IllegalStateException("Invalid property size: " + getPropertySize());
    }
    return giveDiscount(petCost(price));
  }

  @Override
  public String toString() {
    return "Painting: " + super.toString();
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
