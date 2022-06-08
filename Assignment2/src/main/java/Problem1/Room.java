package Problem1;

/**
 * A Room class representing a hotel room booking system that has 3 type of rooms to book.
 */
public class Room {
  private int maxOccupancy;
  private double price;
  private int currGuestNum = 0;

  private static final int EMPTY = 0;

  /**
   * Constructor of Room class
   * @param price - the room booking price.
   * @param currGuestNum - the current guest number of the room.
   * @param maxOccupancy - the maximum occupancy of the room
   * @throws InvalidPriceException if the price is smaller than 1.
   */
  public Room(double price, int currGuestNum, int maxOccupancy) throws
      InvalidPriceException{
    this.currGuestNum = currGuestNum;
    this.maxOccupancy = maxOccupancy;
    if (isValidPrice(price)) {
      this.price = price;
    }
    else {
      throw new InvalidPriceException();
    }
  }

  /**
   * Gets the max room occupancy.
   * @return the max room occupancy.
   */
  public int getMaxOccupancy(){
    return this.maxOccupancy;
  }

  /**
   * Gets the room price.
   * @return the room price.
   */
  public double getPrice() {
    return this.price;
  }

  /**
   * Gets the number of guests.
   * @return the number of guests.
   */
  public int getCurrGuestNum(){
    return this.currGuestNum;
  }

  /**
   * Check if the price is valid.
   * @param price - the booking price.
   * @return True if the price is larger than 0, false otherwise.
   */
  private boolean isValidPrice(double price) {
    return price > EMPTY;
  }

  /**
   * Check if the room is available for check in.
   * @param currGuestNum - current number of guests in the room.
   * @return True if the room is empty, false otherwise.
   */
  public boolean isAvailable(int currGuestNum) {
    return currGuestNum == EMPTY;
  }

  /**
   * Book room if the room is available and the guest number is smaller and equal to the occupancy.
   * @param incomingGuestNum - the guest number.
   * @throws InvalidRmNumException if either of the condition failed.
   */
  public void bookRoom(int incomingGuestNum) throws InvalidRmNumException {
    if (isAvailable(this.currGuestNum) && incomingGuestNum <= this.maxOccupancy) {
        this.currGuestNum = incomingGuestNum;
    } else {
      throw new InvalidRmNumException();
    }
  }
}
