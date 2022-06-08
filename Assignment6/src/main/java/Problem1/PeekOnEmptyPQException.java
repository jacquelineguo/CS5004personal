package Problem1;

public class PeekOnEmptyPQException extends Exception{

  public PeekOnEmptyPQException() {
    super("Cannot peek an empty Priority Queue.");
  }

}
