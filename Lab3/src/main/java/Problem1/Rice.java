package Problem1;

/**
 * Represent a rice.
 */
public class Rice extends NonPerishable{

  /**
   * Constructor for Rice class.
   * @param name - the food name.
   * @param currentPrice - current price for rice.
   * @param currentQt - current quantity of rice.
   * @throws InvalidFoodQtException - if the quantity exceed the maximum quantity.
   */
  public Rice(String name, double currentPrice, Integer currentQt) throws InvalidFoodQtException {
    super(name, currentPrice, currentQt);
  }

  public String getName(){
    return this.name;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Rice rice = (Rice) obj;
    return rice.getName().equals(this.getName());
  }
}
