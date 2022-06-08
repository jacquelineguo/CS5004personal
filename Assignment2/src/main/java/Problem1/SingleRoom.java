package Problem1;

/**
 * A SingleRoom class representing a hotel room that have max occupancy of 1
 */
public class SingleRoom extends Room {

  private static final int MAX_SINGLE_OCCUPANCY = 1;

  /**
   * Constructor for SingleRoom
   * @param price - the booking price.
   * @param guestNum - the number of guests.
   */
  public SingleRoom(double price, int guestNum) throws InvalidPriceException {
    super(price, guestNum, MAX_SINGLE_OCCUPANCY);
  }

}