package A7;

public class Commercial extends Property {

  protected Integer office;
  protected Boolean retail;

  public Commercial(String address, Integer size, Integer office, Boolean retail) {
    super(address, size);

    this.office = office;
    this.retail = retail;

  }
}
