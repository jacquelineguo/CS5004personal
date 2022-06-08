package Problem1;

/**
 * Represent an food ordering system will eventually be expected to automatically generate
 * a daily list of needed food items, and to send it to a grocery retailer
 */
public class FoodOrderingSystem {
  private String retailer;

  /**
   * Constructor for FoodOrderingSystem.
   * @param retailer - grocery retailer.
   */
  public FoodOrderingSystem(String retailer) {
    this.retailer = retailer;
  }

  /**
   * Get the retailer.
   * @return the retailer.
   */
  public String getRetailer() {
    return retailer;
  }

  /**
   * Add meat to the order.
   * @param name - food name.
   * @param currentPrice - current price of the food.
   * @param currentQt - current quantity in stock.
   * @param orderDate - order date.
   * @param expirationDate - food expiration date.
   * @return the meat to add.
   * @throws InvalidFoodQtException if the quantity exceeds the maximum quantity.
   */
  public Meat addMeat(String name, double currentPrice, Integer currentQt, Integer orderDate,
      Integer expirationDate) throws InvalidFoodQtException{
    return new Meat(name, currentPrice, currentQt, orderDate, expirationDate);
  }

  /**
   * Add fruit to the order.
   * @param name - food name.
   * @param currentPrice - current price of the food.
   * @param currentQt - current quantity in stock.
   * @param orderDate - order date.
   * @param expirationDate - food expiration date.
   * @return the fruit to add.
   * @throws InvalidFoodQtException if the quantity exceeds the maximum quantity.
   */
  public Fruit addFruit(String name, double currentPrice, Integer currentQt, Integer orderDate,
      Integer expirationDate) throws InvalidFoodQtException{
    return new Fruit(name, currentPrice, currentQt, orderDate, expirationDate);
  }

  /**
   * Add vegetable to the order.
   * @param name - food name.
   * @param currentPrice - current price of the food.
   * @param currentQt - current quantity in stock.
   * @param orderDate - order date.
   * @param expirationDate - food expiration date.
   * @return the vegetable to add.
   * @throws InvalidFoodQtException if the quantity exceeds the maximum quantity.
   */
  public Vegetable addVegetable(String name, double currentPrice, Integer currentQt,
      Integer orderDate, Integer expirationDate) throws InvalidFoodQtException{
    return new Vegetable(name, currentPrice, currentQt, orderDate, expirationDate);
  }

  /**
   * Add rice to the order.
   * @param name - food name.
   * @param currentPrice - current price of the food.
   * @param currentQt - current quantity in stock.
   * @return rice.
   * @throws InvalidFoodQtException if the quantity exceeds the maximum quantity.
   */
  public Rice addRice(String name, double currentPrice, Integer currentQt)
      throws InvalidFoodQtException{
    return new Rice(name, currentPrice, currentQt);
  }

  /**
   * Add pasta to the order.
   * @param name - food name.
   * @param currentPrice - current price of the food.
   * @param currentQt - current quantity in stock.
   * @return pasta.
   * @throws InvalidFoodQtException if the quantity exceeds the maximum quantity.
   */
  public Pasta addPasta(String name, double currentPrice, Integer currentQt)
      throws InvalidFoodQtException{
    return new Pasta(name, currentPrice, currentQt);
  }

}
