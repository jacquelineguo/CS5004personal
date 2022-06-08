package Problem1;

/**
 * Represent Electrical services class.
 */
public class Electrical extends AbstractSpecialist{
  private static final Integer MAX_EMPLOYEE = 4;
  private static final double PERMIT_FEE = 50.0;

  /**
   * Constructor for Electrical class.
   * @param invoiceID - invoice ID of the service.
   * @param address - service address.
   * @param size - property size which could be small, medium, or large.
   * @param monthly - is a monthly service.
   * @param previousService - the previous service the property got.
   * @param licensedEmployee - number of licensed employee.
   * @param complex - if the service is complex.
   */
  public Electrical(String invoiceID, String address, PropertySize size, boolean monthly,
      Integer previousService, Integer licensedEmployee, boolean complex)
      throws InvalidLicensedEmployeeException{
    super(invoiceID, address, size, monthly, previousService, licensedEmployee, complex);

    if (licensedEmployee > MAX_EMPLOYEE) {
      throw new InvalidLicensedEmployeeException();
    }
  }

  /**
   * Calculates Electrical service price.
   * @return Electrical service price.
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
    return "Electrical: " + super.toString();
  }


}
