package Problem2;

public class LoanApplicationNotFoundException extends Exception {

  public LoanApplicationNotFoundException() {
    super("Cannot find the loan application!");
  }
}
