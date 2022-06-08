package Model;

import java.util.Objects;

/**
 * Seat class represents the seat in the theater.
 */
public class Seat {
  private String seatName;
  private String customerName;

  /**
   * Constructor for Seat class.
   * @param seatName - seat name which could be 'A', 'B', 'C', 'D', ...
   */
  public Seat(String seatName) {
    this.seatName = seatName;
    this.customerName = null;
  }

  /**
   * Constructor for Seat class.
   * @param seatName - seat name which could be 'A', 'B', 'C', 'D', ...
   * @param customerName - customer name if the customer reserved the seats.
   */
  public Seat(String seatName, String customerName) {
    this.seatName = seatName;
    this.customerName = customerName;
  }

  /**
   * Get the seat name.
   * @return the seat name.
   */
  public String getSeatName() {
    return this.seatName;
  }

  /**
   * Get the customer name.
   * @return the customer name.
   */
  public String getCustomerName() {
    return this.customerName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    Seat seat = (Seat) o;
    return Objects.equals(getSeatName(), seat.getSeatName()) && Objects
        .equals(getCustomerName(), seat.getCustomerName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getSeatName(), getCustomerName());
  }

  @Override
  public String toString() {
    return "Seat{" +
        "seatName='" + seatName + '\'' +
        ", customerName='" + customerName + '\'' +
        '}';
  }
}
