package A7;

public class Agents implements IAgent {
  private String name;
  private Listing[] listing;
  private Double commission;
  private Double earnings;

  public Agents(String name, Listing[] listing, Double commission, Double earnings) {
    this.name = name;
    this.listing = listing;
    this.commission = commission;
    this.earnings = earnings;
  }


  public void addListing(Listing listing) {

  }

  public void completeListing(Listing listing){

  }

  public void dropListing(Listing listing) {

  }

  public double getTotalPortfolioValue() {
    return 0;
  }
}
