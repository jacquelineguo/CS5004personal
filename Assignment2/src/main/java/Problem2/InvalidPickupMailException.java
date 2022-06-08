package Problem2;

/**
 * Exception when there's no package to pickup in the locker room.
 */
public class InvalidPickupMailException extends Exception{
  public InvalidPickupMailException() {
    super("No mail in the locker.");
  }

}
