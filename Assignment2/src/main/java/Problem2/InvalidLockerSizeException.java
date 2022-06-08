package Problem2;

/**
 * Exception when the locker size is smaller than the package size.
 */
public class InvalidLockerSizeException extends Exception{
  public InvalidLockerSizeException() {
    super("The item is bigger than the locker, change another one.");
  }

}
