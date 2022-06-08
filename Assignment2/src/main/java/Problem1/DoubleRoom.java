package Problem1;

/**
 * A DoubleRoom class representing a hotel room that have max occupancy of 2
 */
public class DoubleRoom extends Room {

  private static final int MAX_DOUBLE_OCCUPANCY = 2;

  /**
   * Constructor for DoubleRoom
   * @param price - the booking price.
   * @param guestNum - the number of guests.
   */
  public DoubleRoom(double price, int guestNum) throws InvalidPriceException {
    super(price, guestNum, MAX_DOUBLE_OCCUPANCY);
  }


}
