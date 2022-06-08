package Problem1;

public class InvalidNumOfFloorException extends Exception{
  public InvalidNumOfFloorException() {
    super("Invalid number of floor, the maximum is 3.");
  }

}
