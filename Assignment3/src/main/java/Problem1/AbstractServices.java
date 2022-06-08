package Problem1;

import java.util.Objects;

/**
 * Represent all services.
 */
public abstract class AbstractServices implements Services{
  private String invoiceID;
  private String address;
  private PropertySize size;
  private boolean monthly;
  private Integer previousService;
  public static final double PRICE_PER_HR = 80.0;
  private static final Integer TENTH = 10;
  private static final Integer NINE = 9;
  private static final double MONTHLY_DIS = 0.1;
  public static final Integer MED_HR = 2;
  public static final Integer LARGE_HR = 4;
  private static final Integer ZERO = 0;

  /**
   * Constructor for AbstractServices class.
   * @param invoiceID - invoice ID of the service.
   * @param address - service address.
   * @param size - property size which could be small, medium, or large.
   * @param monthly - is a monthly service.
   * @param previousService - the previous service the property got.
   * @throws IllegalArgumentException - if the previous services number is negative.
   */
  public AbstractServices(String invoiceID, String address, PropertySize size, boolean monthly,
      Integer previousService) throws IllegalArgumentException {
    this.invoiceID = invoiceID;
    this.address = address;
    this.size = size;
    this.monthly = monthly;
    if (isNegative(previousService)) {
      throw new IllegalArgumentException("Can't get a negative number of services.");
    }
    else {
      this.previousService = previousService;
    }
  }

  public double calculatePrice() throws IllegalStateException{
    double price;

    switch(getPropertySize()) {
      case SMALL:
        price = PRICE_PER_HR;
        break;
      case MEDIUM:
        price = PRICE_PER_HR * MED_HR;
        break;
      case LARGE:
        price = PRICE_PER_HR * LARGE_HR;
        break;
      default:
        throw new IllegalStateException("Invalid property size: " + getPropertySize());
    }
    return price;
  }
  /**
   * Check if the integer is negative.
   * @param num - an Integer.
   * @return true if the integer is negative, false otherwise.
   */
  boolean isNegative(Integer num) {
    return num < ZERO;
  }

  /**
   * Calculates the discount if it can be applied for monthly service discount or tenth service
   * discount.
   * @param price - total price.
   * @return - discounted price.
   */
  public double giveDiscount(double price) {
    if (this.previousService % TENTH == NINE) {
      price = tenthDiscount(price);
    }
    else if (isMonthly()) {
      price = monthlyDiscount(price);
    }
    return roundPrice(price);
  }

  /**
   * Help method to round the double to decimal.
   * @param price - service price.
   * @return - rounded price.
   */
  private double roundPrice(double price) {
    Integer HUNDRED = 100;
    price = price * HUNDRED;
    price = Math.round(price);
    return price / HUNDRED;
  }

  /**
   * Help function - calculates tenth discount.
   * @param price - service price.
   * @return half price if service time is a tenth service.
   */
  private double tenthDiscount(double price) {
    Integer HALF = 2;
    return price / HALF;
  }

  /**
   * Help function - calculates monthly service discount.
   * @param price - service price.
   * @return - the monthly discount which is 9%.
   */
  private double monthlyDiscount(double price) {
    return price - price * MONTHLY_DIS;
  }

  /**
   * Get property size.
   * @return property size.
   */
  public PropertySize getPropertySize() {
    return this.size;
  }

  /**
   * Check if the service is a monthly service.
   * @return true if it's monthly service, false otherwise.
   */
  public boolean isMonthly() {
    return this.monthly;
  }

  /**
   * Get invoice ID.
   * @return invoice ID.
   */
  public String getInvoiceID() {
    return this.invoiceID;
  }

  /**
   * Get address.
   * @return service address.
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * Get previous service number.
   * @return previous service number.
   */
  public Integer getPreviousService() {
    return this.previousService;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractServices that = (AbstractServices) obj;
    return this.invoiceID == that.invoiceID
        && this.address == that.address
        && this.size == that.size
        && this.monthly == that.monthly
        && this.previousService == that.previousService;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.invoiceID, this.address, this.size, this.monthly,
        this.previousService);
  }

  @Override
  public String toString() {
    return String.format("invoice=%s address='%s' size=%s is monthly=%b serviced=%d",
        this.invoiceID, this.address, this.size, this.monthly, this.previousService);
  }
}
