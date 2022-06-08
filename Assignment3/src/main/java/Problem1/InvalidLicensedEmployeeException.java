package Problem1;

public class InvalidLicensedEmployeeException extends Exception{
  public InvalidLicensedEmployeeException() {
    super("The maximum number of licensed employee is 4.");
  }

}
