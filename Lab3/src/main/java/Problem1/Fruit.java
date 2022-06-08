package Problem1;

/**
 * Represent a fruit.
 */
public class Fruit extends Perishable{

  /**
   * Constructor for Fruit class.
   * @param name - the food name.
   * @param currentPrice - current price for fruit.
   * @param currentQt - current quantity of fruit.
   * @param orderDate - order date of the fruit.
   * @param expirationDate - expiration date of fruit.
   * @throws InvalidFoodQtException - if the quantity exceed the maximum quantity.
   */
  public Fruit(String name, double currentPrice, Integer currentQt, Integer orderDate,
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
    Fruit fruit = (Fruit) obj;
    return fruit.getName().equals(this.getName()) &&
        fruit.getOrderDate().equals(this.getOrderDate());
  }
}
