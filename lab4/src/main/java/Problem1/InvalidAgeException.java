package Problem1;

import javax.swing.SwingUtilities;

public class InvalidAgeException extends Exception{
  public InvalidAgeException() {
    super("The correct age range should be [0, 28]!");
  }

}
