package Problem1;

/**
 * A FamilyRoom class representing a hotel room that have max occupancy of 4
 */
public class FamilyRoom extends Room {

  private static final int MAX_FAMILY_OCCUPANCY = 4;

  /**
   * Constructor for FamilyRoom
   * @param price - the booking price.
   * @param guestNum - the number of guests.
   */
  public FamilyRoom(double price, int guestNum) throws InvalidPriceException {
    super(price, guestNum, MAX_FAMILY_OCCUPANCY);
  }

}
