package A7;

public abstract class Contract {

  protected Double price;
  protected Boolean negotiable;

  public Contract(Double price, Boolean negotiable) {
    this.price = price;
    this.negotiable = negotiable;
  }
}
