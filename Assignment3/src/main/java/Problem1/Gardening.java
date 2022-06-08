package Problem1;

/**
 * Represent Gardening services class.
 */
public class Gardening extends AbstractExterior{
  private static final double WASTE_FEE = 20.0;

  /**
   * Constructor for Gardening class.
   * @param invoiceID - invoice ID of the service.
   * @param address - service address.
   * @param size - property size which could be small, medium, or large.
   * @param monthly - is a monthly service.
   * @param previousService - the previous service the property got.
   */
  public Gardening(String invoiceID, String address, PropertySize size, boolean monthly,
      Integer previousService) {
    super(invoiceID, address, size, monthly, previousService);
  }

  /**
   * Calculates Gardening service price.
   * @return gardening service price.
   */
  public double calculatePrice() {
    return giveDiscount(super.calculatePrice() + WASTE_FEE);
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
    return "Gardening: " + super.toString();
  }
}
