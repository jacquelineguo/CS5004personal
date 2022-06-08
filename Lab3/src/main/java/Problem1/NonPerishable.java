package Problem1;

public abstract class NonPerishable extends Food{
  private static final Integer MAX_QT = 250;

  public NonPerishable(String name, double currentPrice, Integer currentQt)
      throws InvalidFoodQtException {
    super(name, currentPrice, currentQt, MAX_QT);
  }
}
