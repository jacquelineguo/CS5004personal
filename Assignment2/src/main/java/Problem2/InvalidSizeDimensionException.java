package Problem2;

/**
 * Exception when the package size is invalid.
 */
public class InvalidSizeDimensionException extends Exception{
  public InvalidSizeDimensionException() {
    super("Size must be lager than 0.");
  }
}
