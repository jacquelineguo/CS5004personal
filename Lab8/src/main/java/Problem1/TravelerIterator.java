package Problem1;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TravelerIterator implements Iterator<Traveler> {
  private List<Traveler> travelers;
  private int index;

  public TravelerIterator(List<Traveler> travelers) {
    this.travelers = travelers;
    this.index = 0;
  }


  /**
   * Returns {@code true} if the iteration has more elements. (In other words, returns {@code true}
   * if {@link #next} would return an element rather than throwing an exception.)
   *
   * @return {@code true} if the iteration has more elements as required.
   */
  @Override
  public boolean hasNext() {
    while (this.index < travelers.size()) {
      Traveler currentTraveler = this.travelers.get(this.index);
      if (!this.traveledOutUS(currentTraveler)) {
        return true;
      }
      else {
        this.index++;
      }
    }
    return false;
  }

  /**
   * Helper method that check if the traveler traveled outside of US.
   * @param traveler - a traveler to be check.
   * @return true if the traveler traveled outside of US, false otherwise.
   */
  private boolean traveledOutUS(Traveler traveler) {
    for (Destination destination: traveler.traveledDestinations()) {
      if (!destination.getCountry().equals("US")) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the next element in the iteration.
   *
   * @return the next element in the iteration
   * @throws NoSuchElementException if the iteration has no more elements
   */
  @Override
  public Traveler next() {
    if (this.hasNext())
      return this.travelers.get(this.index++);
    else
      throw new NoSuchElementException("No other traveler!");
  }
}
