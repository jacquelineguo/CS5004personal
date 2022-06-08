package problem1;

public class InvalidMoneyAmountException extends Exception{
  public InvalidMoneyAmountException() {
    super("The donation amount cannot smaller than or equal to 0.");
  }

}
