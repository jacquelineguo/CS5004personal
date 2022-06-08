package A7;

public interface IAgent {

  void addListing(Listing listing);

  void completeListing(Listing listing);

  void dropListing(Listing listing);

  double getTotalPortfolioValue();
}
