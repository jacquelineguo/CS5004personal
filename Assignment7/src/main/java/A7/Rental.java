package A7;

import A7.Contract;

public class Rental extends Contract {

  protected Integer leasingTerm;

  public Rental(Double price, Boolean negotiable, Integer leasingTerm) {
    super(price, negotiable);

    this.leasingTerm = leasingTerm;
  }

}
