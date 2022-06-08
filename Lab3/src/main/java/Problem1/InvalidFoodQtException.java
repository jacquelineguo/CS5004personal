package Problem1;

public class InvalidFoodQtException extends Exception{
  public InvalidFoodQtException() {
    super("Current food quantity cannot exceed the maximum allowed quantity.");
  }
}
