package Problem2;

/**
 * Exception when the recipient nama dose not match.
 */
public class InvalidRecipientException extends Exception{
  public InvalidRecipientException() {
    super("Wrong recipient.");
  }
}
