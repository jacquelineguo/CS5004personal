package Problem1;

import java.util.Objects;

/**
 * Represent all interior services.
 */
public abstract class AbstractInterior extends AbstractServices{
  private Integer numOfPets;
  private static final double PET_BOUND = 3;
  private static final double NO_PET = 0;

  /**
   * Constructor for AbstractInterior class
   * @param invoiceID - invoice ID of the service.
   * @param address - service address.
   * @param size - property size which could be small, medium, or large.
   * @param monthly - is a monthly service.
   * @param previousService - the previous service the property got.
   * @param numOfPets - number of pets in the property.
   * @throws IllegalArgumentException if the pet number is smaller than 0.
   */
  public AbstractInterior(String invoiceID, String address, PropertySize size, boolean monthly,
      Integer previousService, Integer numOfPets) throws IllegalArgumentException{
    super(invoiceID, address, size, monthly, previousService);

    if (isNegative(numOfPets)) {
      throw new IllegalArgumentException("The pet number must be larger than or equal to 0.");
    }
    else {
      this.numOfPets = numOfPets;
    }
  }

  /**
   * Calculates the pet cost.
   * @param price - service price.
   * @return the total price includes pet cost.
   */
  protected double petCost(double price) {
    double percent = 0.0;
    if (this.numOfPets >= PET_BOUND) {
      percent = 0.07;
    }
    else if (this.numOfPets > NO_PET){
      percent = 0.05;
    }
    return price + price * percent;
  }

  /**
   * Calculates interior service price.
   * @return interior service price.
   * @throws IllegalStateException if the property is invalid.
   */

  @Override
  public double calculatePrice() {
    return super.calculatePrice();
  }

  @Override
  public String toString() {
    return super.toString() + " pets=" + this.numOfPets;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    AbstractInterior that = (AbstractInterior) obj;
    return this.numOfPets.equals(that.numOfPets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.numOfPets);
  }
}
