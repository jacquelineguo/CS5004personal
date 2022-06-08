package finalExam.p2;

import java.util.Comparator;
import java.util.stream.Collectors;

public class CanadaTripComparator implements Comparator<Traveler> {
  private static final String CANADA = "canada";

  /**
   * Compare travelers based upon the number of times they traveled to Canada over the last three
   * years.
   * @param t1 - first Traveler to compare.
   * @param t2 - second Traveler to compare.
   * @return 0 if the travel times to Canada is equal, -1 if first traveler's traveled times less
   * than second, 1 if the first traveler's traveled times larger than the second.
   */
  @Override
  //YOUR CODE HERE
  public int compare(Traveler t1, Traveler t2) {
    return this.getTravelTimes(t1).compareTo(this.getTravelTimes(t2));
  }

  /**
   * Helper method which helps get the traveled times to Canada of a Traveler.
   * @param traveler - the given Traveler that need to find traveled times to Canada.
   * @return the traveled times to Canada of the given Traveler as an Integer.
   */
  private Integer getTravelTimes(Traveler traveler) {
    return traveler.traveledDestinations().stream().
        filter(destination -> destination.getCountry().equalsIgnoreCase(CANADA)).
        collect(Collectors.toList()).size();
  }
}
