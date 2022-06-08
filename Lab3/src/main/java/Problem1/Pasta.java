package Problem1;

/**
 * Represent a pasta.
 */
public class Pasta extends NonPerishable{

  /**
   * Constructor for Pasta class.
   * @param name - the food name.
   * @param currentPrice - current price for pasta.
   * @param currentQt - current quantity of pasta.
   * @throws InvalidFoodQtException - if the quantity exceed the maximum quantity.
   */
  public Pasta(String name, double currentPrice, Integer currentQt) throws InvalidFoodQtException {
    super(name, currentPrice, currentQt);
  }

  public String getName(){
    return this.name;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Pasta pasta = (Pasta) obj;
    return pasta.getName().equals(this.getName());
  }
}
