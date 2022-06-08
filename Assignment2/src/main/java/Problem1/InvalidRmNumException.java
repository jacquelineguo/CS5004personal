package Problem1;

/**
 * Exception when the room number is invalid.
 */
public class InvalidRmNumException extends Exception{
  public InvalidRmNumException() {
    super("Cannot book the room.");
  }
}
