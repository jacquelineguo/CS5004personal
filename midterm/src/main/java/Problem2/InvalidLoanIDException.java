package Problem2;

public class InvalidLoanIDException extends Exception{

  public InvalidLoanIDException() {
    super("Loan ID cannot find.");
  }
}
