package Problem1;

/**
 * Represent Plumbing services.
 */
public class Plumbing extends AbstractSpecialist{
  private static final double PERMIT_FEE = 20.0;

  /**
   * Constructor for Plumbing class.
   * @param invoiceID - invoice ID of the service.
   * @param address - service address.
   * @param size - property size which could be small, medium, or large.
   * @param monthly - is a monthly service.
   * @param previousService - the previous service the property got.
   * @param licensedEmployee - number of licensed employee.
   * @param complex - if the service is complex.
   */
  public Plumbing(String invoiceID, String address, PropertySize size, boolean monthly,
      Integer previousService, Integer licensedEmployee, boolean complex) {
    super(invoiceID, address, size, monthly, previousService, licensedEmployee, complex);
  }

  /**
   * Calculates Plumbing price.
   * @return the plumbing price.
   */
  @Override
  public double calculatePrice() {
    return giveDiscount(super.calculatePrice() + PERMIT_FEE);
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
    return "Plumbing: " + super.toString();
  }

}
