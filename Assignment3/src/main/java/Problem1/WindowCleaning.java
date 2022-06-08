package Problem1;

/**
 * Represent WindowCleaning services class.
 */
public class WindowCleaning extends AbstractExterior{
  private Integer numOfFloor;
  private static final Integer MAX_FLOOR = 3;
  private static final Integer FLOOR_BOUND = 1;

  /**
   * Constructor for WindowCleaning service class.
   * @param invoiceID - invoice ID of the service.
   * @param address - service address.
   * @param size - property size which could be small, medium, or large.
   * @param monthly - is a monthly service.
   * @param previousService - the previous service the property got.
   * @param numOfFloor - floor numbers.
   * @throws InvalidNumOfFloorException if the floor number is not valid.
   */
  public WindowCleaning(String invoiceID, String address, PropertySize size, boolean monthly,
      Integer previousService, Integer numOfFloor) throws InvalidNumOfFloorException{
    super(invoiceID, address, size, monthly, previousService);

    if (numOfFloor <= MAX_FLOOR && numOfFloor >= FLOOR_BOUND) {
      this.numOfFloor = numOfFloor;
    }
    else {
      throw new InvalidNumOfFloorException();
    }
  }

  /**
   * Get number of floor.
   * @return the number of floor.
   */
  public Integer getNumOfFloor() {
    return this.numOfFloor;
  }

  /**
   * Calculates the price of window cleaning services.
   * @return the price of window cleaning services.
   */
  public double calculatePrice() {
    return giveDiscount(addFloorFee(super.calculatePrice()));
  }

  /**
   * Calculates the additional floor fee.
   * @param price - service price.
   * @return the additional floor plus service fee.
   */
  private double addFloorFee(double price) {
    double FLOOR_ADDON = 0.05;
    if (this.numOfFloor > FLOOR_BOUND) {
      price = price * FLOOR_ADDON + price;
    }
    return price;
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
    WindowCleaning that = (WindowCleaning) obj;
    return this.numOfFloor.equals(that.numOfFloor);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return "Window cleaning: " + super.toString() + " number of floor=" + this.numOfFloor;
  }

}
