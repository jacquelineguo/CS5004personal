package Problem1;

/**
 * Represent all exterior services.
 */
public abstract class AbstractExterior extends AbstractServices{

  /**
   * Constructor for AbstractExterior class
   * @param invoiceID - invoice ID of the service.
   * @param address - service address.
   * @param size - property size which could be small, medium, or large.
   * @param monthly - is a monthly service.
   * @param previousService - the previous service the property got.
   */
  public AbstractExterior(String invoiceID, String address, PropertySize size, boolean monthly,
      Integer previousService) {
    super(invoiceID, address, size, monthly, previousService);
  }

  /**
   * Calculate the price of the Exterior services.
   * @return price of exterior services.
   */
  @Override
  public double calculatePrice() {
    return super.calculatePrice();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
