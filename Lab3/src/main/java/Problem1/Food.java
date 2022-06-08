package Problem1;

public abstract class Food {
  public String name;
  private double currentPrice;
  private Integer currentQt;
  private Integer MAX;

  public Food(String name, double currentPrice, Integer currentQt, Integer MAX)
      throws InvalidFoodQtException{
    this.name = name;
    this.currentPrice = currentPrice;
    this.MAX = MAX;

    if (currentQt > MAX) {
      throw new InvalidFoodQtException();
    }
    else {
      this.currentQt = currentQt;
    }
  }
}
