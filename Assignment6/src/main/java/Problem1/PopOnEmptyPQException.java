package Problem1;

public class PopOnEmptyPQException extends Exception{

  public PopOnEmptyPQException() {
    super("Cannot pop an empty Priority Queue.");
  }
}
