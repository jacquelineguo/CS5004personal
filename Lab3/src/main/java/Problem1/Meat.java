package Problem1;

/**
 * Represent a meat.
 */
public class Meat extends Perishable{

  /**
   * Constructor for Meat class.
   * @param name - the food name.
   * @param currentPrice - current price for meat.
   * @param currentQt - current quantity of meat.
   * @param orderDate - order date of the meat.
   * @param expirationDate - expiration date of meat.
   * @throws InvalidFoodQtException - if the quantity exceed the maximum quantity.
   */
  public Meat(String name, double currentPrice, Integer currentQt, Integer orderDate,
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
    Meat meat = (Meat) obj;
    return meat.getName().equals(this.getName()) &&
        meat.getOrderDate().equals(this.getOrderDate());
  }
}
