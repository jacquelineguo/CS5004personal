package Problem1;

import java.util.Objects;

/**
 * Represent all specialist services.
 */
public abstract class AbstractSpecialist extends AbstractServices{
  public Integer licensedEmployee;
  private boolean complex;
  private double RATE_PER_EMPLOYEE = 200.0;
  private static final Integer MIN_EMPLOYEE = 1;
  private static final Integer COMPLEX_LOWER = 2;
  private static final Integer COMPLEX_UPPER = 3;

  /**
   * Constructor for AbstractSpecialist class.
   * @param invoiceID - invoice ID of the service.
   * @param address - service address.
   * @param size - property size which could be small, medium, or large.
   * @param monthly - is a monthly service.
   * @param previousService - the previous service the property got.
   * @param licensedEmployee - licensed employee number needed.
   * @param complex - if the service is a complex task.
   */
  public AbstractSpecialist(String invoiceID, String address, PropertySize size, boolean monthly,
      Integer previousService, Integer licensedEmployee, boolean complex) {
    super(invoiceID, address, size, monthly, previousService);

    this.complex = complex;

    this.licensedEmployee = licensedEmployee;
    if (complex == true) {
      if (size == PropertySize.SMALL || size == PropertySize.MEDIUM) {
        if (licensedEmployee < COMPLEX_LOWER) {
          this.licensedEmployee = COMPLEX_LOWER;
        }
      }
      else {
        if (licensedEmployee < COMPLEX_UPPER) {
          this.licensedEmployee = COMPLEX_UPPER;
        }
      }
    }
    else {
      if (licensedEmployee < MIN_EMPLOYEE) {
        this.licensedEmployee = MIN_EMPLOYEE;
      }
    }
  }

  /**
   * Get licensed employee number.
   * @return licensed employee number.
   */
  public Integer getLicensedEmployee(){
    return this.licensedEmployee;
  }

  /**
   * Calculates the specialist service price.
   * @return the specialist service price.
   */
  public double calculatePrice() {
    double price = RATE_PER_EMPLOYEE * this.licensedEmployee;
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
    AbstractSpecialist that = (AbstractSpecialist) obj;
    return this.licensedEmployee == that.licensedEmployee
        && this.complex == that.complex;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.licensedEmployee, this.complex);
  }

  @Override
  public String toString() {
    return super.toString() + " licensed employee=" + this.licensedEmployee +
        " is complex=" + this.complex;
  }
}

