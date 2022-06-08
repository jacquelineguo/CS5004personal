package Problem1;

public abstract class Perishable extends Food {
  private static final Integer MAX_QT = 100;
  public Integer orderDate;
  private Integer expirationDate;

  public Perishable(String name, double currentPrice, Integer currentQt, Integer orderDate,
      Integer expirationDate) throws InvalidFoodQtException {
    super(name, currentPrice, currentQt, MAX_QT);

    this.orderDate = orderDate;
    this.expirationDate = expirationDate;
  }
}
