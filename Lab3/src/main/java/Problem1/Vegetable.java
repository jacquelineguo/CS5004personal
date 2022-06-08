package Problem1;

/**
 * Represent a vegetable.
 */
public class Vegetable extends Perishable{

  /**
   * Constructor for Vegetable class.
   * @param name - the food name.
   * @param currentPrice - current price for vegetable.
   * @param currentQt - current quantity of vegetable.
   * @param orderDate - order date of the vegetable.
   * @param expirationDate - expiration date of vegetable.
   * @throws InvalidFoodQtException - if the quantity exceed the maximum quantity.
   */
  public Vegetable(String name, double currentPrice, Integer currentQt, Integer orderDate,
      Integer expirationDate) throws InvalidFoodQtException {
    super(name, currentPrice, currentQt, orderDate, expirationDate);
  }

  public String getName(){
    return this.name;
  }

  public Integer getOrderDate() {
    return this.orderDate;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Vegetable vegetable = (Vegetable) obj;
    return vegetable.getName().equals(this.getName()) &&
        vegetable.getOrderDate().equals(this.getOrderDate());
  }
}
