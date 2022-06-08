package Problem1;

public class InvalidIndexException extends Exception{

  public InvalidIndexException() {
    super("Index out of range.");
  }

}
