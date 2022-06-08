package Problem1;

/**
 * Exception when the price smaller than 1.
 */
public class InvalidPriceException extends Exception {
  public InvalidPriceException() {
    super("Price must be larger than 0.");
  }
}
