package Problem2;

/**
 * Exception when the locker was occupied.
 */
public class InvalidLockerOccupiedException extends Exception{
  public InvalidLockerOccupiedException() {
    super("The locker was occupied, change one.");
  }

}
